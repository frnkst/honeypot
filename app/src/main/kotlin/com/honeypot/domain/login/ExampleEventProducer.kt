package com.honeypot.domain.login

import com.honeypot.kafka.Producer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ExampleEventProducer {

    @Autowired
    private lateinit var producer: Producer

    @Scheduled(fixedRate = 5000)
    fun send() {
        producer.sendMessage("this is an event (${Random.nextInt()})")
    }
}
