package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@IdClass(DiscordMessageId.class)
@Table(name = "discord_message")
public class DiscordMessageEntity {

  @Id
  @ManyToOne
  @JoinColumn(name = "message_id", nullable = false, referencedColumnName = "id")
  private MessageEntity messageEntity;

  @Id
  @Column(name = "discord_message_id")
  private BigInteger discordMessageId;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
