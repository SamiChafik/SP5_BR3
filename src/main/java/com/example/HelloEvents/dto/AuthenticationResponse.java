package com.example.HelloEvents.dto;

public record AuthenticationResponse(
        String token,
        Long id,
        String name,
        String email,
        String role
) {}
