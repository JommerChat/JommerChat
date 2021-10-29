package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reaction")
public class ReactionEntity {

  @Id
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "content")
  private String content;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReactionEntity that = (ReactionEntity) o;
    return id.equals(that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(content, that.content) && Objects.equals(messageEntity, that.messageEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, content, messageEntity);
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public MessageEntity getMessageEntity() {
    return messageEntity;
  }

  public void setMessageEntity(MessageEntity messageEntity) {
    this.messageEntity = messageEntity;
  }

  @ManyToOne
  @JoinColumn(name = "message_id", nullable = false, referencedColumnName = "id")
  private MessageEntity messageEntity;



}
