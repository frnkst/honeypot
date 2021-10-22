package com.honeypot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture
import java.io.IOException
import java.util.*
import kotlin.random.Random


@Component
class WeatherProducer {
    //private val logger: Logger = LoggerFactory.getLogger(javaClass)


    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(topic: String, message: String): ListenableFuture<SendResult<String, String>> {
        //logger.info(java.lang.String.format("#### -> Producing message -> %s", message))
        return kafkaTemplate.send(topic, "hey")
    }

    // fake event
    @get:Throws(IOException::class)
    @get:Scheduled(fixedDelay = 5000)
    val weatherInfoJob: Unit
        get() {
            //logger.info("generate fake weather event")
            // fake event
            println("sending one")
            val event = LoginAttemptEvent(Random.nextInt(),Random.nextInt(), Date() )
            sendMessage("weather", "hey")
        }
}
