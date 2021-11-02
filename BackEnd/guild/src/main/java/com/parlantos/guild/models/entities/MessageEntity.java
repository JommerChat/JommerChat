package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "message")
public class MessageEntity {
  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MessageEntity that = (MessageEntity) o;
    return id.equals(that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(content, that.content) && Objects.equals(memberEntity, that.memberEntity) && Objects.equals(textChannelEntity, that.textChannelEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, content, memberEntity, textChannelEntity);
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

  public MemberEntity getMemberEntity() {
    return memberEntity;
  }

  public void setMemberEntity(MemberEntity memberEntity) {
    this.memberEntity = memberEntity;
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

  @Column(name = "content")
  private String content;

  @ManyToOne
  @JoinColumn(name = "member_id", nullable = false, referencedColumnName = "id")
  private MemberEntity memberEntity;

  @ManyToOne
  @JoinColumn(name = "text_channel_id", nullable = false, referencedColumnName = "id")
  private TextChannelEntity textChannelEntity;
}
