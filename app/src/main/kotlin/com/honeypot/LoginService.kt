package com.honeypot

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException


@Service
class WeatherInfoEventProcessor {
    //private val logger: Logger = LoggerFactory.getLogger(javaClass)
    private var listener: WeatherInfoEventListener? = null
    fun register(listener: WeatherInfoEventListener) {
        this.listener = listener
    }

    fun onEvent(event: String) {
        listener?.onData(event)
    }

    fun onComplete() {
        listener?.processComplete()
    }

    @KafkaListener(topics = ["frank"], groupId = "123")
    fun consume(message: String) {
        //logger.info(String.format("#### -> Consumed message -> %s", message))
        println("yeeey got one")
        onEvent(message)
    }
}
