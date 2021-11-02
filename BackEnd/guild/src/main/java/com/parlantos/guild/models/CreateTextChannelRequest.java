package com.parlantos.guild.models;

import java.math.BigInteger;

public class CreateTextChannelRequest {
  private BigInteger guildId;

  private String title;

  private String description;

  public BigInteger getGuildId() {
    return guildId;
  }

  public void setGuildId(BigInteger guildId) {
    this.guildId = guildId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
