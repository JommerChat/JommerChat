package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "member")
public class MemberEntity {

  @Column(name = "id")
  @Id
  private BigInteger id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "salt")
  private String salt;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "name_tag")
  private String nameTag;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "email")
  private String email;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MemberEntity that = (MemberEntity) o;
    return id.equals(that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(salt, that.salt) && Objects.equals(displayName, that.displayName) && Objects.equals(nameTag, that.nameTag) && Objects.equals(createdAt, that.createdAt) && Objects.equals(email, that.email) && Objects.equals(oktaId, that.oktaId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, salt, displayName, nameTag, createdAt, email, oktaId);
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getNameTag() {
    return nameTag;
  }

  public void setNameTag(String nameTag) {
    this.nameTag = nameTag;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOktaId() {
    return oktaId;
  }

  public void setOktaId(String oktaId) {
    this.oktaId = oktaId;
  }

  @Column(name = "okta_id")
  private String oktaId;

  @Column(name = "avatar")
  private String avatar;

  @Column(name = "discord_id")
  BigInteger discordId;

  @Column(name = "discord_flag")
  Boolean discordFlag;
}
