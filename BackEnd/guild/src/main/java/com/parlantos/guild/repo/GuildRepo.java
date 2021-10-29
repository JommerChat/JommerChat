package com.parlantos.guild.repo;

import com.parlantos.guild.models.GuildEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface GuildRepo extends CrudRepository<GuildEntity, BigInteger> {
}
