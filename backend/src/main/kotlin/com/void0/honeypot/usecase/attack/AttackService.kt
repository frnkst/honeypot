package com.void0.honeypot.usecase.attack


import com.void0.honeypot.repository.MongoRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.apache.kafka.shaded.io.opentelemetry.proto.metrics.v1.Summary
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Instant
import java.time.temporal.ChronoUnit


@Service
class AttackService {
    @Autowired
    private val mongoRepository: MongoRepository? = null

    @Autowired
    private lateinit var reactiveMongoTemplate: ReactiveMongoTemplate

    fun allAttacks(): Flux<Attack?> = mongoRepository!!.findAll()

    fun top(type: String): Flux<Top>? {
        // TODO: How to sort by password ASC when they have the same count?
        val aggregation = newAggregation(
            group(type).count().`as`("count"),
            sort(Sort.by(Sort.Direction.DESC, "count", type, "_id")),
            limit(10),
            project().and("_id").`as`("item").andInclude("count"),
        )

        return reactiveMongoTemplate.aggregate(aggregation, "attack", Top::class.java)
    }

    fun getStatsInParallel(): Mono<StatsSummary> {
        val val1 = getStatsSummary(1)
        val val2 = getStatsSummary(15)
        val val3 = getStatsSummary(60)
        val val4 = getStatsSummary(1440)


        return Mono.zip(val1, val2, val3, val4).map { results ->
            StatsSummary(
                value1 = results.t1,
                value15 = results.t2,
                value60 = results.t3,
                value1440 = results.t4
            )
        }
    }


    private fun getStatsSummary(amountOfMinutesAgo: Long): Mono<Long> {
        val timeAgo = Instant.now().minus(amountOfMinutesAgo, ChronoUnit.MINUTES).epochSecond
        val query = Query(Criteria.where("timestamp").gte(timeAgo))
        return reactiveMongoTemplate.count(query, "attack")
    }
}


data class StatsSummary(
    val value1: Long?,
    val value15: Long?,
    val value60: Long?,
    val value1440: Long?
)
