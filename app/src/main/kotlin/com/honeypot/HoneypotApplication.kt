package com.honeypot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class HoneypotApplication


fun main(args: Array<String>) {
	runApplication<HoneypotApplication>(*args)
}
