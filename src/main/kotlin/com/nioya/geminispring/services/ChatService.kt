package com.nioya.geminispring.services

import com.nioya.geminispring.models.ServiceResult
import dev.langchain4j.model.chat.ChatLanguageModel
import org.springframework.stereotype.Component

@Component
class ChatService(private val model: ChatLanguageModel) {
    fun getAIResponse(request: String): ServiceResult {
        val response: String = model.generate(request)
        return ServiceResult(request, response)
    }
}
