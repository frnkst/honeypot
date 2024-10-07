package com.void0.honeypot.repository

import com.void0.honeypot.usecase.attack.Attack
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MongoRepository : ReactiveMongoRepository<Attack?, String?>
