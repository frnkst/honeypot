package com.honeypot

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MyService {

    private var producer: Producer

    constructor(producer: Producer) {
        this.producer = producer
        this.send()
    }

    @Scheduled(fixedRate = 5000)
    fun send() {
        println("now sending the message")
        producer.sendMessage()
    }
}
