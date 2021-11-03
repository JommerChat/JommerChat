package com.parlantos.guild.models;

import java.math.BigInteger;

public class AddMemberRequest {

  private BigInteger memberId;

  private BigInteger guildId;

  public BigInteger getMemberId() {
    return memberId;
  }

  public void setMemberId(BigInteger memberId) {
    this.memberId = memberId;
  }

  public BigInteger getGuildId() {
    return guildId;
  }

  public void setGuildId(BigInteger guildId) {
    this.guildId = guildId;
  }
}
