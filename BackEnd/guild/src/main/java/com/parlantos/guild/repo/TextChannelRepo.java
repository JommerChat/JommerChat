package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.TextChannelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TextChannelRepo extends CrudRepository<TextChannelEntity, BigInteger> {
}
