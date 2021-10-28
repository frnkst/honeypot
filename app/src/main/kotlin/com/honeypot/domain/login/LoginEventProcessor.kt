package com.honeypot.domain.login

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class LoginEventProcessor {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    private var listener: LoginEventListener? = null
    fun register(listener: LoginEventListener) {
        this.listener = listener
    }

    fun onEvent(event: String) {
        listener?.onData(event)
    }

    fun onComplete() {
        listener?.processComplete()
    }

    @KafkaListener(topics = ["login"], groupId = "2")
    fun consume(message: String) {
        println("got triggered on that subject")
        logger.info(String.format("#### -> Consumed message -> %s", message))
        onEvent(message)
    }
}
