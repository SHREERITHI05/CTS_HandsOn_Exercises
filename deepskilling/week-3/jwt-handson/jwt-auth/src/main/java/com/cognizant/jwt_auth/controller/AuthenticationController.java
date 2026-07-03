package com.cognizant.jwt_auth.controller;

import com.cognizant.jwt_auth.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(Authentication authentication) {
        LOGGER.debug("Start authenticate() method.");

        String username = authentication.getName();
        LOGGER.debug("Authenticated user: {}", username);

        String token = jwtUtil.generateToken(username);
        LOGGER.debug("End authenticate() method.");

        return Collections.singletonMap("token", token);
    }
}