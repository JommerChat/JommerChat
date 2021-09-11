package com.parlantos.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.okta.sdk.resource.user.User;
import com.parlantos.auth.beans.MemberEntity;
import com.parlantos.auth.beans.RegisterRequest;
import com.parlantos.auth.dao.AuthDao;
import com.parlantos.auth.dto.AuthDto;
import com.parlantos.auth.repo.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.okta.sdk.client.Client;

import javax.xml.bind.ValidationException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthService {

  private final AuthDto authDto;
  private final AuthDao authDao;
  private final MemberRepository memberRepository;

  private final Client client;

  private final Logger logger = LoggerFactory.getLogger(AuthService.class);

  AuthService(AuthDto authDto, MemberRepository memberRepository, Client client, AuthDao authDao) {
    this.authDto = authDto;
    this.memberRepository = memberRepository;
    this.client = client;
    this.authDao = authDao;
  }

  public void registerUser(RegisterRequest request) throws ValidationException, JsonProcessingException {
    logger.info("Received request with content: {}", request.toString());
    List<MemberEntity> memberList = this.memberRepository.findByEmail(request.getEmail());
    logger.info("Received list from database: {}", memberList.toString());
    if(memberList.size() != 0) {
      logger.info("That email already exists");
      throw new ValidationException("That email already exists");
    }

    User createdUser = authDao.createOktaUser(request.getUsername(), request.getPassword(), request.getEmail());
    JsonMapper jsonMapper = new JsonMapper();
    logger.info("Created user with User object: {}", jsonMapper.writeValueAsString(createdUser));
    BigInteger result = this.authDto.getSnowflakeId().block();
    this.logger.info("The snowflake result is: {}", result);

    MemberEntity memberEntity = new MemberEntity();
    List<MemberEntity> tagEntity = this.memberRepository.findLastTagByDisplayName(request.getUsername());
    logger.info("Received the tagEntity for username {}: {}", request.getUsername(), tagEntity);
    if(tagEntity == null || tagEntity.isEmpty()) {
      memberEntity.setName_tag("1");
      logger.info("Set base name tag for username: {}", request.getUsername());
    }
    else {
      int targetTag = Integer.parseInt(tagEntity.get(0).getName_tag()) + 1;
      logger.info("Setting name tag {} for user: {}", targetTag, request.getUsername());
      memberEntity.setName_tag(Integer.toString(targetTag));
    }
    memberEntity.setDisplay_name(request.getUsername());
    memberEntity.setUsername(request.getUsername());
    memberEntity.setCreated_at(LocalDateTime.now());
    memberEntity.setEmail(request.getEmail());
    memberEntity.setId(result);
    memberEntity.setOkta_id(createdUser.getId());
    this.memberRepository.save(memberEntity);
    logger.info("Saved new user into database");
  }
}
