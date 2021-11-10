package com.parlantos.guild.controller;

import com.parlantos.guild.models.entities.TextChannelEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/discord/sync")
@Controller
public class DiscordSyncController {

  @GetMapping("/importTextChannels")
  public ResponseEntity<List<TextChannelEntity>> importAllDiscordChannels(@RequestParam String guildId,
                                                                        @RequestParam String discordGuildId) {

  }
}
