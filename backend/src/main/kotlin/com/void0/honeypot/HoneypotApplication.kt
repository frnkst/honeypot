package com.void0.honeypot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoneypotApplication

fun main(args: Array<String>) {
	runApplication<HoneypotApplication>(*args)
}
