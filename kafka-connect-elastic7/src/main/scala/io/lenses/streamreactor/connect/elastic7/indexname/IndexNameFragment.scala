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
package io.lenses.streamreactor.connect.elastic7.indexname

import java.time.Clock
import java.time.LocalDateTime._
import java.time.format.DateTimeFormatter._

object ClockProvider {
  val ClockInstance: Clock = Clock.systemUTC()
}

sealed trait IndexNameFragment {
  def getFragment: String
}

case class TextFragment(text: String) extends IndexNameFragment {
  override def getFragment: String = text
}

case class DateTimeFragment(dateTimeFormat: String, clock: Clock = ClockProvider.ClockInstance)
    extends IndexNameFragment {
  override def getFragment: String = s"${now(clock).format(ofPattern(dateTimeFormat))}"
}
object DateTimeFragment {
  val OpeningChar = '{'
  val ClosingChar = '}'
}