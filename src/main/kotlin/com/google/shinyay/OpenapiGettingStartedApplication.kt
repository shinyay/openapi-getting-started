package com.google.shinyay

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(info = Info(
		description = "Employee API",
		version = "1.0"
))
@SpringBootApplication
class OpenapiGettingStartedApplication

fun main(args: Array<String>) {
	runApplication<OpenapiGettingStartedApplication>(*args)
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this::class.java)