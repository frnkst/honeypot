package com.void0.honeypot.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

@Document(collection = "logins")
data class Login(val username: String, val password: String, val timestamp: String?)
