package com.coin.info.controller;

import com.coin.info.entity.AuthenticationResponse;
import com.coin.info.entity.User;
import com.coin.info.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtUtil jwtUtil;

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getName(), authenticationRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwt = jwtUtil.generateToken(authenticationRequest.getName());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
