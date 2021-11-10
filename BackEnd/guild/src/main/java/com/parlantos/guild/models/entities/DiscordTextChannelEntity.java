package com.parlantos.guild.models.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@IdClass(DiscordTextChannelId.class)
@Table(name = "discord_text_channel")
public class DiscordTextChannelEntity {

  @Id
  @Column(name = "discord_text_channel_id")
  private BigInteger discordTextChannelId;

  @Id
  @ManyToOne
  @JoinColumn(name = "text_channel_id", nullable = false, referencedColumnName = "id")
  private TextChannelEntity textChannelId;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "getmessages")
  private Boolean getMessagesFlag;

  @Column(name = "postmessages")
  private Boolean postMessagesFlag;


}
