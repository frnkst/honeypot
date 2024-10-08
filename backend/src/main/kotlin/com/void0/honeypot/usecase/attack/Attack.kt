package com.void0.honeypot.usecase.attack

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "attack")
data class Attack(val username: String?, val password: String?, val timestamp: String?, val ip: String?, val ipDetails: String?)

data class TopPasswords(val password: String, val count: Int)
data class TopUsernames(val username: String, val count: Int)
data class TopIPAdresses(val ip: String?, val count: Int)
