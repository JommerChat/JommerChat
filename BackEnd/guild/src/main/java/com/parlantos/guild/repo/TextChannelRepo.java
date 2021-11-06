package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.GuildEntity;
import com.parlantos.guild.models.entities.TextChannelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TextChannelRepo extends CrudRepository<TextChannelEntity, BigInteger> {

  List<TextChannelEntity> findAllByGuildEntity(GuildEntity guildEntity);
}
