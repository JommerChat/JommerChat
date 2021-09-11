package com.parlantos.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.parlantos.auth.beans.RegisterRequest;
import com.parlantos.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.ValidationException;

@Controller
@CrossOrigin
@RequestMapping("auth")
public class AuthController {

  AuthService authService;

  AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws ValidationException, JsonProcessingException {
    this.authService.registerUser(request);
    return new ResponseEntity<>("Successfully created user", HttpStatus.OK);
  }

}
