package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = LocalAiProperties.PREFIX)
public class LocalAiProperties {

    static final String PREFIX = "langchain4j.local-ai";

    @NestedConfigurationProperty
    ChatModelProperties chatModel;

    public ChatModelProperties getChatModel() {
        return chatModel;
    }
}
