package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.localai.LocalAiChatModel;

@Configuration
@EnableConfigurationProperties(LocalAiProperties.class)
public class AiConfig {

  @Bean
  @ConditionalOnProperty("langchain4j.local-ai.chat-model.base-url")
  ChatLanguageModel openAiChatModel(LocalAiProperties properties) {
    
      final ChatModelProperties chatModelProperties = properties.getChatModel();
      return LocalAiChatModel.builder()
              .baseUrl(chatModelProperties.baseUrl())
              .modelName(chatModelProperties.modelName())
              .temperature(chatModelProperties.temperature())
              .logRequests(true) // TODO: configure also using properties
              .logResponses(true)
              .build();
  }
}
