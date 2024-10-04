package com.void0.honeypot.domain

import com.void0.honeypot.domain.model.Login
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class LoginsController(val loginService: LoginService) {

    @GetMapping("/logins")
    @CrossOrigin
    fun getLogins(): Flux<Login?> {
        return loginService.allLogins();
    }
}
