package com.ryanhuber.hzdemo.serialization

import com.hazelcast.config.SerializationConfig
import com.hazelcast.config.SerializerConfig
import com.hazelcast.nio.serialization.StreamSerializer

inline fun <reified T : Any> SerializationConfig.addStreamSerializer(serializer: StreamSerializer<T>) {
    val config = SerializerConfig()

    config.implementation = serializer
    config.typeClass = T::class.java

    addSerializerConfig(config)
}