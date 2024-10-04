package com.void0.honeypot.domain

import com.void0.honeypot.domain.model.Login
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface LoginRepository : ReactiveMongoRepository<Login?, String?>
