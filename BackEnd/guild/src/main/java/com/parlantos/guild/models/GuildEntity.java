package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="guild")
public class GuildEntity {
  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "image")
  private String image;

  @OneToMany(mappedBy = "guild")
  private List<PinsEntity> pinsEntityList;

  @OneToMany(mappedBy = "guild")
  private List<GuildMemberEntity> guildMemberEntityList;

  @OneToMany(mappedBy = "guild")
  private List<TextChannelEntity> textChannelEntityList;

  @OneToMany(mappedBy = "guild")
  private List<VoiceChannelEntity> voiceChannelEntityList;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GuildEntity that = (GuildEntity) o;
    return id.equals(that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(image, that.image) && Objects.equals(pinsEntityList, that.pinsEntityList) && Objects.equals(guildMemberEntityList, that.guildMemberEntityList) && Objects.equals(textChannelEntityList, that.textChannelEntityList) && Objects.equals(voiceChannelEntityList, that.voiceChannelEntityList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, name, description, image, pinsEntityList, guildMemberEntityList, textChannelEntityList, voiceChannelEntityList);
  }

  public List<PinsEntity> getPinsEntityList() {
    return pinsEntityList;
  }

  public void setPinsEntityList(List<PinsEntity> pinsEntityList) {
    this.pinsEntityList = pinsEntityList;
  }

  public List<GuildMemberEntity> getGuildMemberEntityList() {
    return guildMemberEntityList;
  }

  public void setGuildMemberEntityList(List<GuildMemberEntity> guildMemberEntityList) {
    this.guildMemberEntityList = guildMemberEntityList;
  }

  public List<TextChannelEntity> getTextChannelEntityList() {
    return textChannelEntityList;
  }

  public void setTextChannelEntityList(List<TextChannelEntity> textChannelEntityList) {
    this.textChannelEntityList = textChannelEntityList;
  }

  public List<VoiceChannelEntity> getVoiceChannelEntityList() {
    return voiceChannelEntityList;
  }

  public void setVoiceChannelEntityList(List<VoiceChannelEntity> voiceChannelEntityList) {
    this.voiceChannelEntityList = voiceChannelEntityList;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}
