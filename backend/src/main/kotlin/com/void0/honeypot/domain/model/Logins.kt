package com.void0.honeypot.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "logins")
data class Login(val username: String, val password: String)
