package com.honeypot.domain.login

interface LoginEventListener {
        fun onData(event: String)
        fun processComplete()
    }
