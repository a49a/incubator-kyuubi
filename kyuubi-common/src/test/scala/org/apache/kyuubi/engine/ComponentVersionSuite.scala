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

package org.apache.kyuubi.engine

import org.apache.kyuubi.KyuubiFunSuite

class ComponentVersionSuite extends KyuubiFunSuite {

  test("parse normal version") {
    val version = new ComponentVersion("1.12.4")
    assert(version.majorVersion === 1)
    assert(version.minorVersion === 12)
    assert(version.patchVersion === "4")
  }

  test("parse snapshot version") {
    val version = new ComponentVersion("2.14.8-SNAPSHOT")
    assert(version.majorVersion === 2)
    assert(version.minorVersion === 14)
    assert(version.patchVersion === "8-SNAPSHOT")
  }
}
