package com.example.HelloEvents.dto;

import com.example.HelloEvents.entities.Role;

public record RegisterRequest(
        String name,
        String email,
        String password,
        Role role
) {}
