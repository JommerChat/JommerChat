package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "role")
public class RoleEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "guild_id", nullable = false, referencedColumnName = "id")
  GuildEntity guildEntity;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RoleEntity that = (RoleEntity) o;
    return id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(guildEntity, that.guildEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, guildEntity);
  }

  public GuildEntity getGuildEntity() {
    return guildEntity;
  }

  public void setGuildEntity(GuildEntity guildEntity) {
    this.guildEntity = guildEntity;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
