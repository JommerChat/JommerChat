package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "voice_channel")
public class VoiceChannelEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "guild_id", nullable = false, referencedColumnName = "id")
  private GuildEntity guildEntity;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    VoiceChannelEntity that = (VoiceChannelEntity) o;
    return id.equals(that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(guildEntity, that.guildEntity) && Objects.equals(title, that.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, guildEntity, title);
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

  public GuildEntity getGuildEntity() {
    return guildEntity;
  }

  public void setGuildEntity(GuildEntity guildEntity) {
    this.guildEntity = guildEntity;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "title")
  private String title;
}
