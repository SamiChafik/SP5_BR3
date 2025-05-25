package com.example.HelloEvents.security;

import com.example.HelloEvents.dto.AuthenticationRequest;
import com.example.HelloEvents.dto.AuthenticationResponse;
import com.example.HelloEvents.dto.RegisterRequest;
import com.example.HelloEvents.entities.Role;
import com.example.HelloEvents.entities.User;
import com.example.HelloEvents.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthenticationService(UserDetailsServiceImpl userDetailsService, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();
        userRepository.save(user);

        UserDetails userDetails = userDetailsService.toUserDetails(user);
        var jwtToken = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userRepository.findByEmail(request.email())
                .orElseThrow();

        UserDetails userDetails = userDetailsService.toUserDetails(user);
        var jwtToken = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(jwtToken);
    }
}