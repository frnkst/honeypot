package com.void0.honeypot.usecase.attack


import com.void0.honeypot.repository.MongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
class AttackService {
    @Autowired
    private val mongoRepository: MongoRepository? = null

    @Autowired
    private lateinit var reactiveMongoTemplate: ReactiveMongoTemplate

    fun allAttacks(): Flux<Attack?> = mongoRepository!!.findAll()

    fun subscribeToAttackEvents(): Flux<Attack>? {
        return reactiveMongoTemplate
            .changeStream(Attack::class.java)
            .watchCollection("attack")
            .listen()
            .mapNotNull { it.body }
    }

    fun topPasswords(): Flux<TopPasswords>? {
        // TODO: How to sort by password ASC when they have the same count?
        val aggregation = newAggregation(
            group("password").count().`as`("count"),
            sort(Sort.by(Sort.Direction.DESC, "count", "password", "_id")),
            limit(10),
            project().and("_id").`as`("password").andInclude("count"),
        )

        return reactiveMongoTemplate.aggregate(aggregation, "attack", TopPasswords::class.java)
    }


}
