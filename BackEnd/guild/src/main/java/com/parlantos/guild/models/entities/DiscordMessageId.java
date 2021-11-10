package com.parlantos.guild.models.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class DiscordMessageId implements Serializable {

  private BigInteger messageId;

  private BigInteger discordMessageId;

  public DiscordMessageId(BigInteger messageId, BigInteger discordMessageId) {
    this.messageId = messageId;
    this.discordMessageId = discordMessageId;
  }

  public BigInteger getMessageId() {
    return messageId;
  }

  public void setMessageId(BigInteger messageId) {
    this.messageId = messageId;
  }

  public BigInteger getDiscordMessageId() {
    return discordMessageId;
  }

  public void setDiscordMessageId(BigInteger discordMessageId) {
    this.discordMessageId = discordMessageId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DiscordMessageId that = (DiscordMessageId) o;
    return messageId.equals(that.messageId) && discordMessageId.equals(that.discordMessageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId, discordMessageId);
  }
}
