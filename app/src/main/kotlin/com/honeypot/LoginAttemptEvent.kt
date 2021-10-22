package com.honeypot

import java.util.*

data class LoginAttemptEvent(val ip: Int, val username: Int, val password: Date)
