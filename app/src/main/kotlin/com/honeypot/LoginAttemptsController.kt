package  com.honeypot

import com.honeypot.model.Usage
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*
import java.util.function.Function

@RestController
class LoginAttemptsController {
    @get:GetMapping(value = ["/event/login"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @get:CrossOrigin(allowedHeaders = ["*"])
    val loginAttempts: Flux<Any>
        get() {
            val random = Random()
            return Flux.interval(Duration.ofSeconds(1))
                    .map(Function { it: Long? ->
                        LoginAttemptEvent(
                                random.nextInt(101),
                                random.nextInt(101),
                                Date())
                    })
        }
}
