package com.void0.honeypot.usecase.attack

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


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

    @GetMapping(path = ["/all-stats"])
    @CrossOrigin
    fun getAllStats(): Mono<StatsSummary> {
        return attackService.getStatsInParallel()
    }
}
