package com.void0.honeypot.usecase.attack

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class AttackController(val attackService: AttackService) {

    @GetMapping("/attacks")
    @CrossOrigin
    fun getAllAttacks(): Flux<Attack?> {
        return attackService.allAttacks()
    }

    @GetMapping("/top-passwords")
    @CrossOrigin
    fun getTopPasswords(): Flux<TopPasswords>? {
        return attackService.topPasswords()
    }

    @GetMapping("/top-usernames")
    @CrossOrigin
    fun getTopUsernames(): Flux<TopUsernames>? {
        return attackService.topUsernames()
    }

    @GetMapping("/top-ips")
    @CrossOrigin
    fun getTopIps(): Flux<TopIPAdresses>? {
        return attackService.topIPAdresses()
    }

    @GetMapping(path = ["/attack-events"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @CrossOrigin
    fun getAttackEvents(): Flux<Attack>? {
        return attackService.subscribeToAttackEvents()
    }
}
