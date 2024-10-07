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
    fun getLogins(): Flux<AttackModel?> {
        return attackService.allAttacks();
    }


    @GetMapping(path = ["/attack-events"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @CrossOrigin
    fun streamFlux(): Flux<AttackModel>? {
        return attackService.subscribeToAttackEvents();


    }
}
