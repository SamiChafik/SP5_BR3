package com.example.HelloEvents.controller;

import com.example.HelloEvents.dto.AuthenticationRequest;
import com.example.HelloEvents.dto.AuthenticationResponse;
import com.example.HelloEvents.dto.RegisterRequest;
import com.example.HelloEvents.entities.User;
import com.example.HelloEvents.repositories.UserRepository;
import com.example.HelloEvents.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}