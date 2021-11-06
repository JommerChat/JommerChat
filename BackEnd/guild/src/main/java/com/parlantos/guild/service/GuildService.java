package com.parlantos.guild.service;

import com.parlantos.guild.dto.SnowflakeDto;
import com.parlantos.guild.models.*;
import com.parlantos.guild.models.entities.*;
import com.parlantos.guild.repo.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GuildService {

  private SnowflakeDto snowflakeDto;
  private GuildRepo guildRepo;
  private MessageRepo messageRepo;
  private TextChannelRepo textChannelRepo;
  private VoiceChannelRepo voiceChannelRepo;
  private MemberRepo memberRepo;
  private GuildMemberRepo guildMemberRepo;

  GuildService(SnowflakeDto snowflakeDto, GuildRepo guildRepo, MessageRepo messageRepo, MemberRepo memberRepo,
               TextChannelRepo textChannelRepo, GuildMemberRepo guildMemberRepo, VoiceChannelRepo voiceChannelRepo) {
    this.snowflakeDto = snowflakeDto;
    this.guildRepo = guildRepo;
    this.messageRepo = messageRepo;
    this.memberRepo = memberRepo;
    this.textChannelRepo = textChannelRepo;
    this.guildMemberRepo = guildMemberRepo;
    this.voiceChannelRepo = voiceChannelRepo;
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

  public GuildMemberEntity addMemberToGuild(AddMemberRequest addMemberRequest) throws ValidationException {
    BigInteger snowflakeId = this.snowflakeDto.getSnowflakeId().block();
    GuildMemberEntity guildMemberEntity = new GuildMemberEntity();
    guildMemberEntity.setId(snowflakeId);
    GuildEntity guildEntity = this.guildRepo.findById(addMemberRequest.getGuildId()).orElseThrow(() -> new ValidationException("The guild id does not exist"));
    MemberEntity memberEntity = this.memberRepo.findById(addMemberRequest.getMemberId()).orElseThrow(() -> new ValidationException("The member id does not exist"));
    guildMemberEntity.setGuildEntity(guildEntity);
    guildMemberEntity.setMemberEntity(memberEntity);
    guildMemberEntity.setCreatedAt(LocalDateTime.now());
    return this.guildMemberRepo.save(guildMemberEntity);
  }

  public VoiceChannelEntity createVoiceChannel(CreateVoiceChannelRequest createVoiceChannelRequest) throws ValidationException {
    BigInteger snowflakeId = this.snowflakeDto.getSnowflakeId().block();
    VoiceChannelEntity voiceChannelEntity = new VoiceChannelEntity();
    voiceChannelEntity.setId(snowflakeId);
    voiceChannelEntity.setCreatedAt(LocalDateTime.now());
    GuildEntity guildEntity = this.guildRepo.findById(createVoiceChannelRequest.getGuildId()).orElseThrow(() -> new ValidationException("The guild id does not exist"));
    voiceChannelEntity.setGuildEntity(guildEntity);
    voiceChannelEntity.setTitle(createVoiceChannelRequest.getTitle());
    return this.voiceChannelRepo.save(voiceChannelEntity);
  }

  public List<MessageEntity> getMessages(String amount, String textChannelId, String startingId) {
    if (startingId == null || startingId.isEmpty()) {
      return this.messageRepo.findRecentMessagesWithLimit(new BigInteger(textChannelId), new BigInteger(amount));
    }
    return this.messageRepo.findMessageEntitiesByIdWithLimit(new BigInteger(startingId), new BigInteger(textChannelId), new BigInteger(amount));
  }

  public List<TextChannelEntity> getTextChannelsInGuild(String guildId) throws ValidationException {
    GuildEntity guildEntity = this.guildRepo.findById(new BigInteger(guildId)).orElseThrow(() -> new ValidationException("The guild id does not exist"));
    return this.textChannelRepo.findAllByGuildEntity(guildEntity);
  }

  public List<VoiceChannelEntity> getVoiceChannelsInGuild(String guildId) throws ValidationException {
    GuildEntity guildEntity = this.guildRepo.findById(new BigInteger(guildId)).orElseThrow(() -> new ValidationException("The guild id does not exist"));
    return this.voiceChannelRepo.findAllByGuildEntity(guildEntity);
  }
}
