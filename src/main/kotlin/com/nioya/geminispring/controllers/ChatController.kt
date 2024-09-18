package com.nioya.geminispring.controllers

import com.nioya.geminispring.services.ChatService
import com.nioya.geminispring.models.ServiceResult
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1", produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Chat", description = "Chat endpoints")
class ChatController(private val chatService: ChatService) {
    val log: Logger = LogManager.getLogger()

    @GetMapping("chat")
    @Operation(summary = "Get Chat response")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Chat response",
            content = [Content(schema = Schema(implementation = String::class))],
        ),
        ApiResponse(responseCode = "404", description = "Test was not found"),
        ApiResponse(responseCode = "500", description = "Unhandled exception"),
    )
    fun getChatData(
        @Parameter(description = "Test Reference")
        @RequestParam("request") request: String,
    ): ResponseEntity<ServiceResult>? {
        log.info("Your request is $request")
        val result = chatService.getAIResponse(request)
        log.info("Gemini Response is ${result.response}")
        return ResponseEntity.ok(result)
    }
}
