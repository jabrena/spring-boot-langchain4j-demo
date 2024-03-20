package com.example.demo.config;

import java.time.Duration;

public record ChatModelProperties(
    String baseUrl,
    String modelName,
    Double temperature,
    Duration timeout) {};
