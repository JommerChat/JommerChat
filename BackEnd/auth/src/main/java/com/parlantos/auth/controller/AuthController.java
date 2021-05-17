package com.parlantos.auth.controller;

import com.parlantos.auth.beans.AuthRequest;
import com.parlantos.auth.beans.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @PostMapping("auth")
    public ResponseEntity<AuthResponse> authUser(@RequestBody AuthRequest authRequest) {

    }

}
