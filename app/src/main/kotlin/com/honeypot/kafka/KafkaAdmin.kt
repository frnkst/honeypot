package com.honeypot

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer


@Configuration
class CorsConfig : WebFluxConfigurer {
    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
            .allowedOrigins("*")
            .maxAge(3600)
    }
}

@Configuration
class KafkaTopicConfig {
    /*
        @Value(value = "\${kafka.bootstrapAddress}")
        private val bootstrapAddress: String? = null
        @Bean
        fun kafkaAdmin(): KafkaAdmin {
            val configs: MutableMap<String, Any?> = HashMap()
            configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
            return KafkaAdmin(configs)
        }

        @Bean
        fun topic1(): NewTopic {
            return NewTopic("baeldung", 1, 1.toShort())
        }

     */
}
