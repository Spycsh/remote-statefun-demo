package org.apache.flink.statefun.playground.aws;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Query {
  @JsonProperty("query_id")
  private String queryId;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("content")
  private String content;

  public Query() {}

  public Query(String queryId, String userId, String content) {
    this.queryId = queryId;
    this.userId = userId;
    this.content = content;
  }

  public String getQueryId() {
    return queryId;
  }

  public void setQueryId(String queryId) {
    this.queryId = queryId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
