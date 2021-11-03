package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.GuildEntity;
import com.parlantos.guild.models.entities.GuildMemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface GuildMemberRepo extends CrudRepository<GuildMemberEntity, BigInteger> {
  List<GuildMemberEntity> findAllByGuildEntity(GuildEntity guildEntity);
}
