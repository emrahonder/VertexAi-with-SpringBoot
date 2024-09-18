package com.nioya.geminispring.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.nioya.geminispring.controllers"])
class SwaggerConfig {
    @Bean
    fun v1TestGroup(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("v1")
            .displayName("v1")
            .addOpenApiCustomizer { openApi: OpenAPI ->
                openApi.info =
                    Info()
                        .title("Chat")
                        .description("Chat endpoints")
                        .version("1.0")
            }
            .pathsToMatch("/v1/chat")
            .build()
    }
}