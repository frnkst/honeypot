package com.void0.honeypot.repository

import com.void0.honeypot.usecase.attack.Attack
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface MongoRepository : ReactiveMongoRepository<Attack?, String?> {
    fun findFirst20ByOrderByIdDesc(): Flux<Attack>
}
