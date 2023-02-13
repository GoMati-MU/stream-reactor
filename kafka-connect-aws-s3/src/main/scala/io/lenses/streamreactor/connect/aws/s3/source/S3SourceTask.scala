/*
 * Copyright 2017-2023 Lenses.io Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lenses.streamreactor.connect.aws.s3.source

import cats.implicits.toBifunctorOps
import com.datamountaineer.streamreactor.common.utils.JarManifest
import com.typesafe.scalalogging.LazyLogging
import io.lenses.streamreactor.connect.aws.s3.model.location.RemoteS3PathLocationWithLine
import io.lenses.streamreactor.connect.aws.s3.model.location.RemoteS3RootLocation
import io.lenses.streamreactor.connect.aws.s3.source.state.CleanS3SourceTaskState
import io.lenses.streamreactor.connect.aws.s3.source.state.S3SourceTaskState
import org.apache.kafka.connect.source.SourceRecord
import org.apache.kafka.connect.source.SourceTask

import java.time.Clock
import java.util
import scala.jdk.CollectionConverters.SeqHasAsJava

class S3SourceTask extends SourceTask with LazyLogging {

  implicit val contextPropsFn: () => util.Map[String, String] = SourceContextReader.getProps(() => context)
  implicit val contextOffsetFn: RemoteS3RootLocation => Option[RemoteS3PathLocationWithLine] =
    SourceContextReader.getCurrentOffset(() => context)
  implicit val clock: Clock = Clock.systemDefaultZone()

  private val manifest = JarManifest(getClass.getProtectionDomain.getCodeSource.getLocation)

  private var s3SourceTaskState: S3SourceTaskState = CleanS3SourceTaskState

  override def version(): String = manifest.version()

  /**
    * Start sets up readers for every configured connection in the properties
    */
  override def start(props: util.Map[String, String]): Unit = {

    logger.debug(s"Received call to S3SourceTask.start with ${props.size()} properties")
    s3SourceTaskState = s3SourceTaskState
      .start(props)
      .leftMap(throw _)
      .merge
  }

  override def stop(): Unit = {
    logger.debug(s"Received call to S3SourceTask.stop")
    s3SourceTaskState = s3SourceTaskState.close()
    ()
  }

  override def poll(): util.List[SourceRecord] =
    s3SourceTaskState
      .poll()
      .leftMap(throw _)
      .merge
      .asJava

}
