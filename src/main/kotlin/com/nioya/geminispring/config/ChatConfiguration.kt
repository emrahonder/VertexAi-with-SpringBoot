package com.nioya.geminispring.config

import dev.langchain4j.model.chat.ChatLanguageModel
import dev.langchain4j.model.vertexai.VertexAiGeminiChatModel
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatConfiguration {
    @Value("\${spring.cloud.gcp.project-id}")
    private val projectId: String = ""

    @Value("\${spring.cloud.gcp.location}")
    private val location: String = ""

    @Value("\${spring.cloud.gcp.model-name}")
    private val modelName: String = ""

    @Bean
    fun chatMemory(): ChatLanguageModel {
        return VertexAiGeminiChatModel.builder().project(projectId).location(location)
            .modelName(modelName).build()
    }
}
