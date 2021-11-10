package com.parlantos.guild.repo;

import com.parlantos.guild.models.entities.DiscordTextChannelEntity;
import com.parlantos.guild.models.entities.DiscordTextChannelId;
import org.springframework.data.repository.CrudRepository;

public interface DiscordTextChannelRepo extends CrudRepository<DiscordTextChannelEntity, DiscordTextChannelId> {
}
