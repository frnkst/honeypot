package com.honeypot.kafka


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.lang.Nullable
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

private const val topicName = "frank"


@Component
class Producer {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(message: String) {
        val future: ListenableFuture<SendResult<String, String>> = kafkaTemplate.send(topicName, message)

        future.addCallback(object : ListenableFutureCallback<SendResult<String, String>> {
            override fun onSuccess(@Nullable result: SendResult<String, String>?) {
                println("Sent message=[" + message +
                        "] with offset=[" + result!!.recordMetadata.offset() + "]")
            }

            override fun onFailure(ex: Throwable) {
                println("Unable to send message=["
                        + message + "] due to : " + ex.message)
            }
        })
    }
}
