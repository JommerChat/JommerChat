package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "role_permission")
public class RolePermissionEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
  private RoleEntity roleEntity;

  public BigInteger getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RolePermissionEntity that = (RolePermissionEntity) o;
    return id.equals(that.id) && Objects.equals(roleEntity, that.roleEntity) && Objects.equals(permissionEntity, that.permissionEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, roleEntity, permissionEntity);
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public RoleEntity getRoleEntity() {
    return roleEntity;
  }

  public void setRoleEntity(RoleEntity roleEntity) {
    this.roleEntity = roleEntity;
  }

  public PermissionEntity getPermissionEntity() {
    return permissionEntity;
  }

  public void setPermissionEntity(PermissionEntity permissionEntity) {
    this.permissionEntity = permissionEntity;
  }

  @ManyToOne
  @JoinColumn(name = "permission_id", nullable = false, referencedColumnName = "id")
  private PermissionEntity permissionEntity;
}
