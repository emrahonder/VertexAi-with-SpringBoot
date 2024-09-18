package com.nioya.geminispring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GeminiSpringApplication

fun main(args: Array<String>) {
    runApplication<GeminiSpringApplication>(*args)
}
