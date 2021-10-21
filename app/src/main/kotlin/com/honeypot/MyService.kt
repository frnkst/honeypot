package com.honeypot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MyService {


    constructor(producer: Producer) {
        println("here")
        producer.sendMessage()
    }
}
