/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kyuubi.engine.flink

import com.google.common.annotations.VisibleForTesting

import org.apache.kyuubi.config.KyuubiConf
import org.apache.kyuubi.operation.log.OperationLog

class FlinkProcessBuilder115(
    override val proxyUser: String,
    override val conf: KyuubiConf,
    override val engineRefId: String,
    override val extraEngineLog: Option[OperationLog] = None)
  extends FlinkProcessBuilder(proxyUser, conf, engineRefId, extraEngineLog) {

  @VisibleForTesting
  def this(proxyUser: String, conf: KyuubiConf) {
    this(proxyUser, conf, "")
  }

  override protected def module: String = "kyuubi-flink-sql-engine-1.15"

  override protected def mainClass: String = "org.apache.kyuubi.engine.flink.FlinkSQLEngine115"

}
