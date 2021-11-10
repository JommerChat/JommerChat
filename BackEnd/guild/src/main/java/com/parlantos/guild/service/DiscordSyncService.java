package com.parlantos.guild.service;

import com.parlantos.guild.models.entities.GuildEntity;
import com.parlantos.guild.models.entities.TextChannelEntity;
import com.parlantos.guild.repo.GuildRepo;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.math.BigInteger;
import java.util.List;

@Service
public class DiscordSyncService {

  private GuildRepo guildRepo;
  private GuildService guildService;

  DiscordSyncService(GuildRepo guildRepo, GuildService guildService) {
    this.guildRepo = guildRepo;
    this.guildService = guildService;
  }

  public List<TextChannelEntity> importAllDiscordChannels(String guildId, String discordGuildId) throws ValidationException {
    //find the guild entity that text channels will be added to
    GuildEntity guildEntity = this.guildRepo.findById(new BigInteger(guildId)).orElseThrow(() -> new ValidationException("The guild id does not exist"));


    this.guildService.createTextChannel();
  }
}
