package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "permission")
public class PermissionEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PermissionEntity that = (PermissionEntity) o;
    return id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(rolePermissionEntity, that.rolePermissionEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, rolePermissionEntity);
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<RolePermissionEntity> getRolePermissionEntity() {
    return rolePermissionEntity;
  }

  public void setRolePermissionEntity(List<RolePermissionEntity> rolePermissionEntity) {
    this.rolePermissionEntity = rolePermissionEntity;
  }

  @OneToMany
  private List<RolePermissionEntity> rolePermissionEntity;

}
