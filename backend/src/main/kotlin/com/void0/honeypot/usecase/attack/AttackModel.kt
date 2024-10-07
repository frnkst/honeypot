package com.void0.honeypot.usecase.attack

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "attack")
data class AttackModel(val username: String, val password: String, val timestamp: String?)
