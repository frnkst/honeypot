package com.honeypot

import org.springframework.stereotype.Component

@Component
class MyService(producer: Producer) {

    init {
        println("here")
        Thread.sleep(15000)
        println("now sending the message")
        producer.sendMessage()
    }
}
