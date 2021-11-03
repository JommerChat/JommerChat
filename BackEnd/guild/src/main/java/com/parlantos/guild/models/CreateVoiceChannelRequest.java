package com.parlantos.guild.models;

import java.math.BigInteger;

public class CreateVoiceChannelRequest {

  private BigInteger guildId;

  private String title;

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
}
