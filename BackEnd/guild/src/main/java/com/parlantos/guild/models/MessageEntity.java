package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
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
    return id.equals(that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(content, that.content) && Objects.equals(memberEntity, that.memberEntity) && Objects.equals(textChannelEntity, that.textChannelEntity) && Objects.equals(pins, that.pins) && Objects.equals(reaction, that.reaction) && Objects.equals(reply, that.reply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, content, memberEntity, textChannelEntity, pins, reaction, reply);
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

  public List<PinsEntity> getPins() {
    return pins;
  }

  public void setPins(List<PinsEntity> pins) {
    this.pins = pins;
  }

  public List<ReactionEntity> getReaction() {
    return reaction;
  }

  public void setReaction(List<ReactionEntity> reaction) {
    this.reaction = reaction;
  }

  public List<ReplyEntity> getReply() {
    return reply;
  }

  public void setReply(List<ReplyEntity> reply) {
    this.reply = reply;
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

  @OneToMany
  private List<PinsEntity> pins;

  @OneToMany
  private List<ReactionEntity> reaction;

  @OneToMany
  private List<ReplyEntity> reply;
}
