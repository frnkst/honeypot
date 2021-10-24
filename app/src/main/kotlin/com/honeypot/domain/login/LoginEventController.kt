package com.honeypot.domain.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink


@RestController
@CrossOrigin
class LoginEventController {
    @Autowired
    private lateinit var processor: LoginEventProcessor
    private val bridge: Flux<String>

    @get:GetMapping(value = ["/events/login"], produces = ["text/event-stream;charset=UTF-8"])
    val loginEvent: Flux<String> get() = bridge

    private fun createBridge(): Flux<String> {
        return Flux.create { sink: FluxSink<String> ->
            processor.register(object: LoginEventListener {
                override fun processComplete() {
                    sink.complete()
                }

                override fun onData(event: String) {
                    sink.next(event)
                }
            })
        }
    }

    init {
        bridge = createBridge().publish().autoConnect().cache(10).log()
    }
}
