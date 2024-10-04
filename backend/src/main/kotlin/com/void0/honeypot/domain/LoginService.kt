package com.void0.honeypot.domain

import com.void0.honeypot.domain.model.Login
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class LoginService {
    @Autowired
    private val loginRepository: LoginRepository? = null

    fun allLogins(): Flux<Login?> = loginRepository!!.findAll()

    fun getLoginById(id: String): Mono<Login?> {
        return loginRepository!!.findById(id)
    }
}
