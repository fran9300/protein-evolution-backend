package com.proteinevolution.backend.dto;


public record HealthResponse(
        String application,
        String status,
        String version
) {}