package com.honeypot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MyService {

    @Autowired
    private lateinit var producer: Producer

    @Scheduled(fixedRate = 5000)
    fun send() {
        println("now sending the message")
        producer.sendMessage("yeeeeyyy working")
    }
}
