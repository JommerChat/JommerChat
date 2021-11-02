package com.parlantos.guild.service;

import com.parlantos.guild.dto.SnowflakeDto;
import com.parlantos.guild.models.CreateGuildRequest;
import com.parlantos.guild.models.CreateMessageRequest;
import com.parlantos.guild.models.CreateTextChannelRequest;
import com.parlantos.guild.models.entities.GuildEntity;
import com.parlantos.guild.models.entities.MemberEntity;
import com.parlantos.guild.models.entities.MessageEntity;
import com.parlantos.guild.models.entities.TextChannelEntity;
import com.parlantos.guild.repo.GuildRepo;
import com.parlantos.guild.repo.MemberRepo;
import com.parlantos.guild.repo.MessageRepo;
import com.parlantos.guild.repo.TextChannelRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.xml.bind.ValidationException;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
public class GuildService {

  private SnowflakeDto snowflakeDto;
  private GuildRepo guildRepo;
  private MessageRepo messageRepo;
  private TextChannelRepo textChannelRepo;
  private MemberRepo memberRepo;

  GuildService(SnowflakeDto snowflakeDto, GuildRepo guildRepo, MessageRepo messageRepo, MemberRepo memberRepo, TextChannelRepo textChannelRepo) {
    this.snowflakeDto = snowflakeDto;
    this.guildRepo = guildRepo;
    this.messageRepo = messageRepo;
    this.memberRepo = memberRepo;
    this.textChannelRepo = textChannelRepo;
  }


  public GuildEntity createGuild(CreateGuildRequest createGuildRequest) throws ValidationException {
    if(createGuildRequest.getName() == null || createGuildRequest.getName().isEmpty()) {
      throw new ValidationException("The Guild Name must not be null");
    }
    BigInteger snowflakeId = this.snowflakeDto.getSnowflakeId().block();
    GuildEntity guildEntity = new GuildEntity();
    guildEntity.setCreatedAt(LocalDateTime.now());
    guildEntity.setDescription(createGuildRequest.getDescription());
    guildEntity.setName(createGuildRequest.getName());
    guildEntity.setImage(createGuildRequest.getImage());
    guildEntity.setId(snowflakeId);
    return this.guildRepo.save(guildEntity);
  }

  public MessageEntity createMessage(CreateMessageRequest createMessageRequest) throws ValidationException {
    MemberEntity memberEntity = this.memberRepo.findById(createMessageRequest.getUserId()).orElseThrow(() -> new ValidationException("The provided member id does not exist"));
    TextChannelEntity textChannelEntity = this.textChannelRepo.findById(createMessageRequest.getTextChannelId()).orElseThrow(() -> new ValidationException("The provided text channel id does not exist"));
    MessageEntity messageEntity = new MessageEntity();
    messageEntity.setId(this.snowflakeDto.getSnowflakeId().block());
    messageEntity.setMemberEntity(memberEntity);
    messageEntity.setTextChannelEntity(textChannelEntity);
    messageEntity.setCreatedAt(LocalDateTime.now());
    messageEntity.setContent(createMessageRequest.getContent());
    this.messageRepo.save(messageEntity);
    return messageEntity;
  }

  public TextChannelEntity createTextChannel(CreateTextChannelRequest createTextChannelRequest) throws ValidationException {
    BigInteger snowflakeId = this.snowflakeDto.getSnowflakeId().block();
    TextChannelEntity textChannelEntity = new TextChannelEntity();
    textChannelEntity.setId(snowflakeId);
    GuildEntity guildEntity = this.guildRepo.findById(createTextChannelRequest.getGuildId()).orElseThrow(() -> new ValidationException("The guild id does not exist"));
    textChannelEntity.setGuildEntity(guildEntity);
    textChannelEntity.setCreatedAt(LocalDateTime.now());
    textChannelEntity.setTitle(createTextChannelRequest.getTitle());
    textChannelEntity.setDescription(createTextChannelRequest.getDescription());
    return this.textChannelRepo.save(textChannelEntity);
  }
}
