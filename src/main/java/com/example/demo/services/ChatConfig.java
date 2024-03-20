package com.example.demo.services;

import java.util.Scanner;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class ChatConfig {

    @Bean
    public WorkaholicsAgent customerSupportAgent(ChatLanguageModel chatLanguageModel) {
        return AiServices.builder(WorkaholicsAgent.class)
                .chatLanguageModel(chatLanguageModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                .build();
    }

    @Bean
    ApplicationRunner interactiveChatRunner(WorkaholicsAgent agent) {
        return args -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("User: ");
                String userMessage = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userMessage)) {
                    break;
                }

                String agentMessage = agent.chat(userMessage);
                System.out.println("Agent: " + agentMessage);
            }

            scanner.close();
        };
    }

}
