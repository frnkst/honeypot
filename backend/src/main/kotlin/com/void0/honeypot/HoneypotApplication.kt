package com.void0.honeypot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoneypotApplication

fun main(args: Array<String>) {
	runApplication<HoneypotApplication>(*args)


	val myList = listOf("test", "apple", "apple")
	val abc = myList
		.groupingBy{it}
		.eachCount()
		.maxByOrNull { it.value }
		?.key
	println(abc)
}
