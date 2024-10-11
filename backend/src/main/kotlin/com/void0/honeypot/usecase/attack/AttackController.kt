package com.void0.honeypot.usecase.attack

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class AttackController(val attackService: AttackService) {

    @GetMapping("/attacks")
    @CrossOrigin
    fun getAllAttacks(): Flux<Attack?> {
        return attackService.allAttacks()
    }

    @GetMapping("/top")
    @CrossOrigin
    fun getTop(@RequestParam type: String): Flux<Top>? {
        return attackService.top(type)
    }

    @GetMapping(path = ["/attack-events"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @CrossOrigin
    fun getAttackEvents(): Flux<Attack>? {
        return attackService.subscribeToAttackEvents()
    }
}

enum class TopType(val value: String) {
    PASSWORD("password"),
    USERNAME("username"),
    IP("ip")
}
