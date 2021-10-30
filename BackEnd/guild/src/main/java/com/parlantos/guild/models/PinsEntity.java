package com.parlantos.guild.models;


import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pins")
public class PinsEntity {
  public BigInteger getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PinsEntity that = (PinsEntity) o;
    return id.equals(that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(messageEntity, that.messageEntity) && Objects.equals(guildEntity, that.guildEntity) && Objects.equals(textChannelEntity, that.textChannelEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, messageEntity, guildEntity, textChannelEntity);
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

  public MessageEntity getMessageEntity() {
    return messageEntity;
  }

  public void setMessageEntity(MessageEntity messageEntity) {
    this.messageEntity = messageEntity;
  }

  public GuildEntity getGuildEntity() {
    return guildEntity;
  }

  public void setGuildEntity(GuildEntity guildEntity) {
    this.guildEntity = guildEntity;
  }

  public TextChannelEntity getTextChannelEntity() {
    return textChannelEntity;
  }

  public void setTextChannelEntity(TextChannelEntity textChannelEntity) {
    this.textChannelEntity = textChannelEntity;
  }

  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "message_id", nullable = false, referencedColumnName = "id")
  private MessageEntity messageEntity;

  @ManyToOne
  @JoinColumn(name = "server_id", nullable = false, referencedColumnName = "id")
  private GuildEntity guildEntity;

  @ManyToOne
  @JoinColumn(name = "text_channel_id", nullable = false, referencedColumnName = "id")
  private TextChannelEntity textChannelEntity;
}
