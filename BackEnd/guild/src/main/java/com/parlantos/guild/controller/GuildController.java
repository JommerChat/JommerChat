package com.parlantos.guild.controller;

import com.parlantos.guild.models.AddMemberRequest;
import com.parlantos.guild.models.CreateGuildRequest;
import com.parlantos.guild.models.CreateMessageRequest;
import com.parlantos.guild.models.CreateTextChannelRequest;
import com.parlantos.guild.models.entities.*;
import com.parlantos.guild.repo.GuildMemberRepo;
import com.parlantos.guild.repo.GuildRepo;
import com.parlantos.guild.repo.MemberRepo;
import com.parlantos.guild.service.GuildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/guild")
public class GuildController {

  private MemberRepo memberRepo;
  private GuildMemberRepo guildMemberRepo;
  private GuildService guildService;
  private GuildRepo guildRepo;

  GuildController(MemberRepo memberRepo, GuildService guildService, GuildMemberRepo guildMemberRepo, GuildRepo guildRepo) {
    this.memberRepo = memberRepo;
    this.guildService = guildService;
    this.guildMemberRepo = guildMemberRepo;
    this.guildRepo = guildRepo;
  }

  @GetMapping("/members")
  public ResponseEntity<List<MemberEntity>> getMembers(@RequestParam String id) throws ValidationException {
    GuildEntity guildEntity = this.guildRepo.findById(new BigInteger(id)).orElseThrow(() -> new ValidationException("The guild id does not exist"));
    List<GuildMemberEntity> guildMemberEntities = this.guildMemberRepo.findAllByGuildEntity(guildEntity);
    List<MemberEntity> memberEntities = new LinkedList<>();
    guildMemberEntities.forEach(member -> memberEntities.add(member.getMemberEntity()));
    return new ResponseEntity<>(memberEntities, HttpStatus.OK);
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
