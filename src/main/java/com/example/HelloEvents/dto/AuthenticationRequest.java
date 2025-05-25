package com.example.HelloEvents.dto;

public record AuthenticationRequest(
        String email,
        String password
) {}
