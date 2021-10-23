package com.honeypot.domain.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink


@RestController // (1) Spring MVC annotation
class WeatherController {
    @Autowired
    private lateinit var processor: WeatherInfoEventProcessor
    private val bridge: Flux<String>

    // (1) Spring MVC annotation
    @get:GetMapping(value = ["/weather"], produces = ["text/event-stream;charset=UTF-8"])
    val weatherInfo: Flux<String>
        get() = bridge

    private fun createBridge(): Flux<String> {
        return Flux.create { sink: FluxSink<String> ->  // (2)
            processor.register(object: WeatherInfoEventListener {
                override fun processComplete() {
                    sink.complete()
                }

                override fun onData(event: String) {
                    println("frank on data")
                    sink.next(event)
                }
            })
        }
    }

    init {
        // (3) Broadcast to several subscribers
        bridge = createBridge().publish().autoConnect().cache(10).log()
    }
}
