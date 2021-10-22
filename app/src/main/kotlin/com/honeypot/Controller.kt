import WeatherInfoEvent.LoginAttemptEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.util.function.Consumer


@RestController // (1) Spring MVC annotation
class Controller {
    @Autowired
    private val processor: WeatherInfoEventProcessor? = null
    private val bridge: Flux<LoginAttemptEvent>

    // (1) Spring MVC annotation
    @get:GetMapping(value = ["/weather"], produces = ["text/event-stream;charset=UTF-8"])
    val weatherInfo: Flux<Any>
        get() = bridge

    private fun createBridge(): Flux<LoginAttemptEvent> {
        return Flux.create<LoginAttemptEvent>(Consumer<FluxSink<LoginAttemptEvent>> { sink: FluxSink<LoginAttemptEvent> ->  // (2)
            processor.register(object : LoginAttemptEventListener {
                override fun processComplete() {
                    sink.complete()
                }

                override fun onData(event: LoginAttemptEvent?) {
                    sink.next(data)
                }
            })
        })
    }

    init {
        // (3) Broadcast to several subscribers
        bridge = createBridge().publish().autoConnect().cache(10).log()
    }
}
