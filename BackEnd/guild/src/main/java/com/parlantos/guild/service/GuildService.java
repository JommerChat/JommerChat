package com.parlantos.guild.service;

import com.parlantos.guild.dto.SnowflakeDto;
import com.parlantos.guild.models.CreateGuildRequest;
import com.parlantos.guild.models.entities.GuildEntity;
import com.parlantos.guild.repo.GuildRepo;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.time.LocalDateTime;

@Service
public class GuildService {

  private SnowflakeDto snowflakeDto;
  private GuildRepo guildRepo;

  GuildService(SnowflakeDto snowflakeDto, GuildRepo guildRepo) {
    this.snowflakeDto = snowflakeDto;
    this.guildRepo = guildRepo;
  }


  public GuildEntity createGuild(CreateGuildRequest createGuildRequest) throws ValidationException {
    if(createGuildRequest.getName() == null || createGuildRequest.getName().isEmpty()) {
      throw new ValidationException("Name must not be null");
    }

    GuildEntity guildEntity = new GuildEntity();
    guildEntity.setCreatedAt(LocalDateTime.now());
    guildEntity.setDescription(createGuildRequest.getDescription());
    guildEntity.setName(createGuildRequest.getName());
    guildEntity.setId(this.snowflakeDto.getSnowflakeId().block());
    this.guildRepo.save(guildEntity);
    return guildEntity;
  }

}
