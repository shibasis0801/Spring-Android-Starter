package com.overlord.server


import com.overlord.common.HelloWorld
import com.overlord.common.api.server.DiagnosticsAPIConfig
import com.overlord.common.api.server.DiagnosticsAPIContract
import com.overlord.common.api.server.Hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ShibasisApplication

fun main(args: Array<String>) {
	runApplication<ShibasisApplication>(*args)
}



@RestController
@RequestMapping(DiagnosticsAPIConfig.BASE)
class Diagnostics: DiagnosticsAPIContract {
	@GetMapping(DiagnosticsAPIConfig.Routes.HELLO)
	override suspend fun helloWorld() = Hello("Hello From Spring")
}

@RestController
class HomePage {
	@GetMapping("/")
	fun helloSpring() = "Hello Spring"

	@GetMapping("/hello")
	fun testObject() = Hello("Shibasis Is Patnaik")

	@GetMapping("/common")
	fun testCommonModule() = Hello(HelloWorld())
}