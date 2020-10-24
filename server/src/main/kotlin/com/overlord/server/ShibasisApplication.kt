package com.overlord.server

import com.overlord.common.HelloWorld
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ShibasisApplication

fun main(args: Array<String>) {
	runApplication<ShibasisApplication>(*args)
}

data class Hello(val text: String)

@RestController
class HomePage {
	@GetMapping("/")
	fun helloSpring() = "Hello Spring"

	@GetMapping("/hello")
	fun testObject() = Hello("Shibasis Is Patnaik")

	@GetMapping("/common")
	fun testCommonModule() = Hello(HelloWorld())
}