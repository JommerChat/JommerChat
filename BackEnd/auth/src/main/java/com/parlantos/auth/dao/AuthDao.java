package com.parlantos.auth.dao;

import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.ResourceException;
import com.okta.sdk.resource.user.User;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class AuthDao {

  @Value("${okta.client.org-url}")
  String oktaOrgUrl;

  @Value("${okta.client.token}")
  String oktaApiToken;

  public User createOktaUser(String username, String password, String email) throws ValidationException {
    Client client = Clients.builder()
      .setOrgUrl(oktaOrgUrl)
      .setClientCredentials(new TokenClientCredentials(oktaApiToken))
      .build();
    UserList userList = client.listUsers();
    if(userList.stream().anyMatch(s -> s.getProfile().getEmail().equals(email))) {
      throw new ValidationException("That email already exists");
    }
    try {
      return UserBuilder.instance()
        .setEmail(email)
        .setFirstName(username)
        .setPassword(password.toCharArray())
        .setActive(true)
        .buildAndCreate(client);
    } catch(ResourceException e) {
      throw new ValidationException(e.getMessage());
    }
  }

}
