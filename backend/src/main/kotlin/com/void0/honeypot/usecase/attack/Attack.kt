package com.void0.honeypot.usecase.attack

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "attack")
data class Attack(val username: String?, val password: String?, val timestamp: String?, val ip: String?, val ipDetails: String?)

data class Top(val item: String, val count: Int)
