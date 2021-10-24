package com.sshd

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.sshd.server.SshServer
import org.apache.sshd.server.keyprovider.AbstractGeneratorHostKeyProvider
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider
import org.apache.sshd.server.subsystem.SubsystemFactory
import org.apache.sshd.sftp.server.SftpSubsystemFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Paths


val jsonMapper = ObjectMapper().apply {
    registerKotlinModule()
    disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    setDateFormat(StdDateFormat())
}

object SSHDeamon {
    private const val BIND_ADDRESS = "127.0.0.1" // only listen to localhost
    private const val SSHD_PORT = 2228
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @JvmStatic
    fun main(argv: Array<String>) {
        val sshd = SshServer.setUpDefaultServer()
        sshd.host = BIND_ADDRESS
        sshd.port = SSHD_PORT

        // If the host key does not exist yet, it will be auto-created
        val hostKeyProvider: AbstractGeneratorHostKeyProvider = SimpleGeneratorHostKeyProvider(Paths.get("hostkey.ser"))

        hostKeyProvider.algorithm = "RSA"
        sshd.keyPairProvider = hostKeyProvider

        val namedFactoryList: MutableList<SubsystemFactory> = ArrayList()
        namedFactoryList.add(SftpSubsystemFactory())
        sshd.subsystemFactories = namedFactoryList
        sshd.passwordAuthenticator = Authenticator()
        try {
            logger.info("Starting dummy sshd on bind_address:port $BIND_ADDRESS:$SSHD_PORT")
            sshd.start()
            while (true) {
                Thread.sleep(2000)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
