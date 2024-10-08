package com.void0.honeypot

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import kotlin.test.Test

class FluxTesting {
    @Test
    fun monoTest() {
        val helloMono = Mono.just("Hello")
        StepVerifier.create(helloMono)
            .expectNext("Hello")
            .expectComplete()
            .verify()
    }

    @Test
    fun fluxTest() {
        val helloFlux = Flux.just("Hello", "Flux")
        StepVerifier.create(helloFlux)
            .expectNext("Hello")
            .expectNext("Flux")
            .expectComplete()
            .verify()
    }

    @Test
    fun fluxWithErrorResume() {
        val fluxWithError = Flux.just("Hello", "Test", "Error")
            .handle { str, sink ->
                if (str == "Test") {
                    sink.error(RuntimeException("Throwing Error"))
                    return@handle
                }
                sink.next(str)
            }

        val a = fluxWithError.onErrorResume { Mono.just("Recovered") }


        StepVerifier.create(a)
            .expectNext("Hello")
            .expectNext("Recovered")
            .expectComplete()
            .verify()
    }

    @Test
    fun fluxWithErrorReturn() {
        val fluxWithError = Flux.just("Hello", "Test", "Something")
            .handle { str, sink ->
                if (str == "Test") {
                    sink.error(RuntimeException("Throwing Error"))
                    return@handle
                }
                sink.next(str)
            }

        val a = fluxWithError.onErrorReturn("Recovered")


        StepVerifier.create(a)
            .expectNext("Hello")
            .expectNext("Recovered")
            .expectComplete()
            .verify()
    }
}
