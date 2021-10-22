package com.honeypot

interface WeatherInfoEventListener {
        fun onData(event: String)
        fun processComplete()
    }
