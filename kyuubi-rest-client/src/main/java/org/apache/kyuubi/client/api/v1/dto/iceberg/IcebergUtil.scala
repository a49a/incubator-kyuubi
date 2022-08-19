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

package org.apache.kyuubi.client.api.v1.dto.iceberg

import scala.collection.JavaConverters._

object IcebergUtil {

  def generateRewriteSQL(dto: RewriteDataFilesRequest): String = {

    val REWRITE_DATA_FILES = "rewrite_data_files"

    val optionBuf = new StringBuffer
    if (dto.getStrategy != null) {
      optionBuf.append(", strategy => '")
      optionBuf.append(dto.getStrategy.name())
      optionBuf.append("'")
    }

    dto.getStrategy match {
      case RewriteStrategyEnum.SORT =>
        optionBuf.append(", sort_order => '")
        // TODO add sort order
        dto.getSortOrderEnum match {
          case SortOrderEnum.Z_ORDER =>
          case _ =>
        }
        optionBuf.append("'")
      case _ =>
    }

    if (dto.getOptions != null && dto.getOrdinaryOrderOptions.length > 0) {
      optionBuf.append(" options => map(")
      for (kv <- dto.getOptions.asScala) {
        optionBuf.append(s"'${kv._1}', '${kv._2}', ")
      }
      optionBuf.append(")")
    }
    val optionsStr = optionBuf.toString

    s"CALL ${dto.getCatalog}.system.${REWRITE_DATA_FILES}" +
      s"(table = '${dto.getNamespace}.${dto.getTable}'${optionsStr})"
  }
}
