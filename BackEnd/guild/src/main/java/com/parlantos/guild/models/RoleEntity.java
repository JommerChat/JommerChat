package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role")
public class RoleEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "role")
  private List<RolePermissionEntity> rolePermissionEntityList;

  @OneToMany(mappedBy = "role")
  private List<GuildRoleEntity> guildRoleEntityList;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RoleEntity that = (RoleEntity) o;
    return id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(rolePermissionEntityList, that.rolePermissionEntityList) && Objects.equals(guildRoleEntityList, that.guildRoleEntityList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, rolePermissionEntityList, guildRoleEntityList);
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

  public List<RolePermissionEntity> getRolePermissionEntityList() {
    return rolePermissionEntityList;
  }

  public void setRolePermissionEntityList(List<RolePermissionEntity> rolePermissionEntityList) {
    this.rolePermissionEntityList = rolePermissionEntityList;
  }

  public List<GuildRoleEntity> getGuildRoleEntityList() {
    return guildRoleEntityList;
  }

  public void setGuildRoleEntityList(List<GuildRoleEntity> guildRoleEntityList) {
    this.guildRoleEntityList = guildRoleEntityList;
  }
}
