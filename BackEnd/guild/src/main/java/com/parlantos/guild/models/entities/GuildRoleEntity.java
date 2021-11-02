package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "guild_role")
public class GuildRoleEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @ManyToOne
  @JoinColumn(name = "guild_member_id", nullable = false, referencedColumnName = "id")
  private GuildMemberEntity guildMemberEntity;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GuildRoleEntity that = (GuildRoleEntity) o;
    return id.equals(that.id) && Objects.equals(guildMemberEntity, that.guildMemberEntity) && Objects.equals(roleEntity, that.roleEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, guildMemberEntity, roleEntity);
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public GuildMemberEntity getGuildMemberEntity() {
    return guildMemberEntity;
  }

  public void setGuildMemberEntity(GuildMemberEntity guildMemberEntity) {
    this.guildMemberEntity = guildMemberEntity;
  }

  public RoleEntity getRoleEntity() {
    return roleEntity;
  }

  public void setRoleEntity(RoleEntity roleEntity) {
    this.roleEntity = roleEntity;
  }

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
  private RoleEntity roleEntity;
}
