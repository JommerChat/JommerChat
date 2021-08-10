package com.parlantos.auth.repo;


import com.parlantos.auth.beans.MemberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface MemberRepository extends CrudRepository<MemberEntity, BigInteger> {

  public List<MemberEntity> findByEmail(String email);

  @Query("SELECT m from MemberEntity m where m.display_name = :displayName ORDER BY m.display_name DESC")
  public List<MemberEntity> findLastTagByDisplayName(@Param("displayName") String displayName);
}
