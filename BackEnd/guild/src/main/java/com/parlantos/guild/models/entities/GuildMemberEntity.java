package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "guild_member")
public class GuildMemberEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @ManyToOne
  @JoinColumn(name = "member_id", nullable = false, referencedColumnName = "id")
  private MemberEntity memberEntity;

  @ManyToOne
  @JoinColumn(name = "guild_id", nullable = false, referencedColumnName = "id")
  private GuildEntity guildEntity;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GuildMemberEntity that = (GuildMemberEntity) o;
    return id.equals(that.id) && Objects.equals(memberEntity, that.memberEntity) && Objects.equals(guildEntity, that.guildEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, memberEntity, guildEntity);
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public MemberEntity getMemberEntity() {
    return memberEntity;
  }

  public void setMemberEntity(MemberEntity memberEntity) {
    this.memberEntity = memberEntity;
  }

  public GuildEntity getGuildEntity() {
    return guildEntity;
  }

  public void setGuildEntity(GuildEntity guildEntity) {
    this.guildEntity = guildEntity;
  }
}
