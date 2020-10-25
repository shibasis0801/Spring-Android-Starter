package com.overlord.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShibasisApplication

fun main(args: Array<String>) {
	runApplication<ShibasisApplication>(*args)
}