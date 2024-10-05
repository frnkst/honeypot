package com.void0.honeypot.domain

import com.void0.honeypot.domain.model.Login
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalTime


@RestController
class LoginsController(val loginService: LoginService) {

    @GetMapping("/logins")
    @CrossOrigin
    fun getLogins(): Flux<Login?> {
        return loginService.allLogins();
    }


    @GetMapping(path = ["/stream-flux"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @CrossOrigin
    fun streamFlux(): Flux<Login>? {
        return loginService.subscribe();


    }
}
