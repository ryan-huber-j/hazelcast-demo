package com.ryanhuber.hzdemo.config

import com.hazelcast.config.Config
import com.hazelcast.config.MapConfig
import com.ryanhuber.hzdemo.serialization.ContactKeySerializer
import com.ryanhuber.hzdemo.serialization.ContactSerializer
import com.ryanhuber.hzdemo.serialization.addStreamSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HazelcastConfiguration {
    @Bean
    fun serverConfig(contactKeySerializer: ContactKeySerializer, contactSerializer: ContactSerializer): Config {
        val config = Config()

        val contactsMapConfig = MapConfig()
        contactsMapConfig.name = CONTACTS_MAP_NAME

        config.serializationConfig.addStreamSerializer(contactKeySerializer)
        config.serializationConfig.addStreamSerializer(contactSerializer)

        config.addMapConfig(contactsMapConfig)

        return config
    }
}