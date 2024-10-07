package com.void0.honeypot.usecase.attack

import com.void0.honeypot.repository.MongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class AttackService {
    @Autowired
    private val mongoRepository: MongoRepository? = null

    @Autowired
    private val reactiveMongoTemplate: ReactiveMongoTemplate? = null

    fun allAttacks(): Flux<AttackModel?> = mongoRepository!!.findAll()

    fun subscribeToAttackEvents(): Flux<AttackModel>? {
        return reactiveMongoTemplate
            ?.changeStream(AttackModel::class.java)
            ?.watchCollection("attack")
            ?.listen()
            ?.mapNotNull { it.body }
    }
}
