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

package org.apache.kyuubi.client.api.v1.dto.iceberg;

import java.util.Map;

public class RewriteDataFilesRequest {

  private String catalog;
  private String namespace;
  private String table;
  private RewriteStrategyEnum strategy;

  private SortOrderEnum sortOrderEnum;
  private OrdinaryOrderOption[] ordinaryOrderOptions;
  private String[] zOrderColNames;

  private Map<String, String> options;
  private String where;

  private boolean runAsync;
  private Long queryTimeout;

  public String getCatalog() {
    return catalog;
  }

  public void setCatalog(String catalog) {
    this.catalog = catalog;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public RewriteStrategyEnum getStrategy() {
    return strategy;
  }

  public void setStrategy(RewriteStrategyEnum strategy) {
    this.strategy = strategy;
  }

  public SortOrderEnum getSortOrderEnum() {
    return sortOrderEnum;
  }

  public void setSortOrderEnum(SortOrderEnum sortOrderEnum) {
    this.sortOrderEnum = sortOrderEnum;
  }

  public OrdinaryOrderOption[] getOrdinaryOrderOptions() {
    return ordinaryOrderOptions;
  }

  public void setOrdinaryOrderOptions(OrdinaryOrderOption[] ordinaryOrderOptions) {
    this.ordinaryOrderOptions = ordinaryOrderOptions;
  }

  public String[] getzOrderColNames() {
    return zOrderColNames;
  }

  public void setzOrderColNames(String[] zOrderColNames) {
    this.zOrderColNames = zOrderColNames;
  }

  public Map<String, String> getOptions() {
    return options;
  }

  public void setOptions(Map<String, String> options) {
    this.options = options;
  }

  public String getWhere() {
    return where;
  }

  public void setWhere(String where) {
    this.where = where;
  }

  public boolean isRunAsync() {
    return runAsync;
  }

  public void setRunAsync(boolean runAsync) {
    this.runAsync = runAsync;
  }

  public Long getQueryTimeout() {
    return queryTimeout;
  }

  public void setQueryTimeout(Long queryTimeout) {
    this.queryTimeout = queryTimeout;
  }
}
