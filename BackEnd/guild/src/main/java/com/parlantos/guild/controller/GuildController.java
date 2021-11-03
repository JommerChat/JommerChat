package com.parlantos.guild.controller;

import com.parlantos.guild.models.AddMemberRequest;
import com.parlantos.guild.models.CreateGuildRequest;
import com.parlantos.guild.models.CreateMessageRequest;
import com.parlantos.guild.models.CreateTextChannelRequest;
import com.parlantos.guild.models.entities.*;
import com.parlantos.guild.repo.MemberRepo;
import com.parlantos.guild.service.GuildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.ValidationException;
import java.util.List;

@Controller
@RequestMapping("/guild")
public class GuildController {

  private MemberRepo memberRepo;
  private GuildService guildService;

  GuildController(MemberRepo memberRepo, GuildService guildService) {
    this.memberRepo = memberRepo;
    this.guildService = guildService;
  }

  @GetMapping("/members")
  public ResponseEntity<List<MemberEntity>> getMembers() {
    List<MemberEntity> members = (List<MemberEntity>) this.memberRepo.findAll();
    return new ResponseEntity<>(members, HttpStatus.OK);
  }

  @PostMapping("/addMemberToGuild")
  public ResponseEntity<GuildMemberEntity> addMemberToGuild(@RequestBody AddMemberRequest addMemberRequest) throws ValidationException {
    return new ResponseEntity<>(this.guildService.addMemberToGuild(addMemberRequest), HttpStatus.OK);
  }

  @PostMapping("/createGuild")
  public ResponseEntity<GuildEntity> createGuild(@RequestBody CreateGuildRequest createGuildRequest) throws ValidationException {
    return new ResponseEntity<>(this.guildService.createGuild(createGuildRequest), HttpStatus.OK);
  }

  @PostMapping("/createMessage")
  public ResponseEntity<MessageEntity> createMessage(@RequestBody CreateMessageRequest createMessageRequest) throws ValidationException {
    return new ResponseEntity<>(this.guildService.createMessage(createMessageRequest), HttpStatus.OK);
  }

  @PostMapping("/createTextChannel")
  public ResponseEntity<TextChannelEntity> createTextChannel(@RequestBody CreateTextChannelRequest createTextChannelRequest) throws ValidationException {
    return new ResponseEntity<>(this.guildService.createTextChannel(createTextChannelRequest), HttpStatus.OK);
  }

}
