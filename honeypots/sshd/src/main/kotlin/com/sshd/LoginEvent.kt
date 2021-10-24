package com.sshd

data class LoginEvent(
    val ip: String,
    val user: String,
    val password: String
)
