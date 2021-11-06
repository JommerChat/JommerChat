package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.MessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MessageRepo extends PagingAndSortingRepository<MessageEntity, BigInteger> {

  @Query(value = "SELECT * FROM message m WHERE m.text_channel_id = :textChannelId and m.id < :lastMessageId order by m.id desc LIMIT :limit", nativeQuery = true)
  List<MessageEntity> findMessageEntitiesByIdWithLimit(@Param("lastMessageId") BigInteger lastMessageId,
                                                       @Param("textChannelId") BigInteger textChannelId,
                                                       @Param("limit") BigInteger limit);

  @Query(value = "SELECT * FROM message m WHERE m.text_channel_id = :textChannelId LIMIT :limit", nativeQuery = true)
  List<MessageEntity> findRecentMessagesWithLimit(@Param("textChannelId") BigInteger textChannelId,
                                                  @Param("limit") BigInteger limit);
}
