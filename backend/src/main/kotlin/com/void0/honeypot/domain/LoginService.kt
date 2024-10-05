package com.void0.honeypot.domain

import com.void0.honeypot.domain.model.Login
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.sse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class LoginService {
    @Autowired
    private val loginRepository: LoginRepository? = null

    @Autowired
    private val eventListener: EventListener? = null;

    fun allLogins(): Flux<Login?> = loginRepository!!.findAll()

    fun getLoginById(id: String): Mono<Login?> {
        return loginRepository!!.findById(id)
    }

    fun subscribe(): Flux<Login>? {
        return eventListener?.subscribe()
    }
}


@Component
class EventListener(private val template: ReactiveMongoTemplate) {

    fun subscribe(): Flux<Login> {
        return template
            .changeStream(Login::class.java)
            .watchCollection("logins")
            .listen()
            .mapNotNull { it.body }
    }
}
