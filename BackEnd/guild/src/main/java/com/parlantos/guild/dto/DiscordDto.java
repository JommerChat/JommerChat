package com.parlantos.guild.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DiscordDto {

  private final Logger logger = LoggerFactory.getLogger(DiscordDto.class);

  @Value("${discord_bot.baseUrl:192.168.1.49:8093/discord}")
  private String discordBotUrl;

  private final WebClient webClient = WebClient.create();


}
