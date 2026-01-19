package com.matrixagents.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class LangChainConfigOpenAi {

    @ConfigProperty(name = "azure.openai.api-key")
    String apiKey;

    @ConfigProperty(name = "azure.openai.endpoint")
    String endpoint;

    @ConfigProperty(name = "azure.openai.deployment", defaultValue = "gpt-5-nano")
    String deploymentName;

    @Produces
    @ApplicationScoped
    @Named("defaultChatModel")
    public ChatModel chatModel() {
        return OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(deploymentName)
                .build();
    }

    @Produces
    @ApplicationScoped
    @Named("plannerModel")
    public ChatModel plannerModel() {
        return OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(deploymentName)
                .build();
    }
}
