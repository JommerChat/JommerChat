package com.parlantos.guild.models;

import java.math.BigInteger;

public class CreateMessageRequest {

  private BigInteger userId;

  private String content;

  private BigInteger textChannelId;

  public BigInteger getUserId() {
    return userId;
  }

  public void setUserId(BigInteger userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public BigInteger getTextChannelId() {
    return textChannelId;
  }

  public void setTextChannelId(BigInteger textChannelId) {
    this.textChannelId = textChannelId;
  }
}
