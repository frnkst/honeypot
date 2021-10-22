package com.honeypot.model

import java.util.*

class Usage {
    var cpuUsage = 0
    var memoryUsage = 0
    var date: Date? = null

    constructor() {}
    constructor(cpuUsage: Int, memoryUsage: Int, date: Date?) {
        this.cpuUsage = cpuUsage
        this.memoryUsage = memoryUsage
        this.date = date
    }
}
