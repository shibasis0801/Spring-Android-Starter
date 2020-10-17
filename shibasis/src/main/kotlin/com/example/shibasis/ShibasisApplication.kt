package com.example.shibasis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ShibasisApplication

fun main(args: Array<String>) {
	runApplication<ShibasisApplication>(*args)
}

@RestController
class HomePage {
	@GetMapping("/")
	fun helloSpring() = "Hello Spring"
}