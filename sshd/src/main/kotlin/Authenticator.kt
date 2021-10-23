package de.metamorphant.examples.chattysshd

import org.apache.sshd.server.auth.AsyncAuthException
import org.apache.sshd.server.auth.password.PasswordAuthenticator
import org.apache.sshd.server.auth.password.PasswordChangeRequiredException
import org.apache.sshd.server.session.ServerSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Authenticator : PasswordAuthenticator {
   // private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Throws(PasswordChangeRequiredException::class, AsyncAuthException::class)
    override fun authenticate(username: String?, password: String?, session: ServerSession?): Boolean {
        /*
        logger.debug(

            String.format(
                "Login attempt by user '%s' with password '%s'\n",
                username,
                password
            )
        )
        */
        println("attempt by ${username} with ${password}")
        return false // Authentication with our dummy server always fails
    }
}

