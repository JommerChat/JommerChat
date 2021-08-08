package com.parlantos.auth.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "member")
public class MemberEntity {

  private BigInteger id;
  private String username;
  private String password;
  private String salt;
  private String display_name;
  private String name_tag;
  private LocalDateTime created_at;
  private String email;
  private String okta_id;

  @Id
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

  public String getDisplay_name() {
    return display_name;
  }

  public void setDisplay_name(String display_name) {
    this.display_name = display_name;
  }

  public String getName_tag() {
    return name_tag;
  }

  public void setName_tag(String name_tag) {
    this.name_tag = name_tag;
  }

  public LocalDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOkta_id() {
    return okta_id;
  }

  public void setOkta_id(String okta_id) {
    this.okta_id = okta_id;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ").add("Id: " + this.id.toString())
      .add("Username: " + this.username)
      .add("Password: " + this.password)
      .add("Salt: " + this.salt)
      .add("DisplayName: " + this.display_name)
      .add("NameTag: " + this.name_tag)
      .add("CreatedAt: " + this.created_at)
      .add("Email: " + this.email)
      .add("OktaId: " + this.okta_id).toString();
  }

}
