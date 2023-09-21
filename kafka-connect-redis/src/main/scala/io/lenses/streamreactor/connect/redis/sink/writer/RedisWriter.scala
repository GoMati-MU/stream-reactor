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
package io.lenses.streamreactor.connect.redis.sink.writer

import io.lenses.streamreactor.common.errors.ErrorHandler
import io.lenses.streamreactor.common.sink.DbWriter
import io.lenses.streamreactor.connect.redis.sink.config.RedisSinkSettings
import com.typesafe.scalalogging.StrictLogging
import io.lenses.streamreactor.connect.security.StoreInfo
import redis.clients.jedis.Jedis

import java.io.File
import java.io.FileNotFoundException

/**
  * Responsible for taking a sequence of SinkRecord and write them to Redis
  */
abstract class RedisWriter extends DbWriter with StrictLogging with ErrorHandler {

  var jedis: Jedis = _

  def createClient(sinkSettings: RedisSinkSettings): Unit = {
    val connection = sinkSettings.connectionInfo

    if (connection.isSslConnection) {
      connection.storesInfo.keyStore.foreach {
        case StoreInfo(path: String, _, _) if !new File(path).exists =>
          throw new FileNotFoundException(s"Keystore not found in: [$path]")
        case StoreInfo(path: String, storeType: Option[String], storePassword: Option[String]) =>
          System.setProperty("javax.net.ssl.keyStorePassword", storePassword.getOrElse(""))
          System.setProperty("javax.net.ssl.keyStore", path)
          System.setProperty("javax.net.ssl.keyStoreType", storeType.getOrElse("jceks"))
      }
      connection.storesInfo.trustStore.foreach {
        case StoreInfo(path: String, _, _) if !new File(path).exists =>
          throw new FileNotFoundException(s"trustStore not found in: [$path]")
        case StoreInfo(path: String, storeType: Option[String], storePassword: Option[String]) =>
          System.setProperty("javax.net.ssl.trustStorePassword", storePassword.getOrElse(""))
          System.setProperty("javax.net.ssl.trustStore", path)
          System.setProperty("javax.net.ssl.trustStoreType", storeType.getOrElse("jceks"))
      }
    }

    jedis = new Jedis(connection.host, connection.port, connection.isSslConnection)
    connection.password.foreach(p => jedis.auth(p))

    //initialize error tracker
    initialize(sinkSettings.taskRetries, sinkSettings.errorPolicy)
  }

  def close(): Unit =
    if (jedis != null) {
      jedis.close()
    }

}
