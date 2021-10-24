package com.sshd

import org.apache.sshd.server.auth.AsyncAuthException
import org.apache.sshd.server.auth.password.PasswordAuthenticator
import org.apache.sshd.server.auth.password.PasswordChangeRequiredException
import org.apache.sshd.server.session.ServerSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.apache.kafka.clients.producer.ProducerRecord

class Authenticator : PasswordAuthenticator {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    private val producer = createProducer("localhost:29092")

    @Throws(PasswordChangeRequiredException::class, AsyncAuthException::class)
    override fun authenticate(username: String?, password: String?, session: ServerSession?): Boolean {
        logger.debug("Login attempt by user $username with password $password")

        val loginEvent = LoginEvent("192.168.0.1", username!!, password!!)
        val loginEventJson = jsonMapper.writeValueAsString(loginEvent)

        val futureResult = producer.send(ProducerRecord("login", loginEventJson))
        futureResult.get()

        return false // Authentication with our dummy server always fails
    }
}

