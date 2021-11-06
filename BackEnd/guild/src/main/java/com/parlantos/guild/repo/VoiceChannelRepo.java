package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.GuildEntity;
import com.parlantos.guild.models.entities.VoiceChannelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VoiceChannelRepo extends CrudRepository<VoiceChannelEntity, BigInteger> {
  List<VoiceChannelEntity> findAllByGuildEntity(GuildEntity guildEntity);
}
