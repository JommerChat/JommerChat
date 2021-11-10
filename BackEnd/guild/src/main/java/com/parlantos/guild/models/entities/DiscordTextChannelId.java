package com.parlantos.guild.models.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class DiscordTextChannelId implements Serializable {

  private BigInteger discordTextChannelId;

  private BigInteger textChannelId;

  public DiscordTextChannelId(BigInteger discordTextChannelId, BigInteger textChannelId) {
    this.discordTextChannelId = discordTextChannelId;
    this.textChannelId = textChannelId;
  }

  public BigInteger getDiscordTextChannelId() {
    return discordTextChannelId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DiscordTextChannelId that = (DiscordTextChannelId) o;
    return discordTextChannelId.equals(that.discordTextChannelId) && textChannelId.equals(that.textChannelId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discordTextChannelId, textChannelId);
  }

  public void setDiscordTextChannelId(BigInteger discordTextChannelId) {
    this.discordTextChannelId = discordTextChannelId;
  }

  public BigInteger getTextChannelId() {
    return textChannelId;
  }

  public void setTextChannelId(BigInteger textChannelId) {
    this.textChannelId = textChannelId;
  }
}
