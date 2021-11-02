package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.MemberEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface MemberRepo extends CrudRepository<MemberEntity, BigInteger> {
}
