package com.honeypot.domain.login

interface WeatherInfoEventListener {
        fun onData(event: String)
        fun processComplete()
    }
