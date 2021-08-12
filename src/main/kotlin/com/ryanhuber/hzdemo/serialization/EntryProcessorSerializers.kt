package com.ryanhuber.hzdemo.serialization

import com.hazelcast.nio.ObjectDataInput
import com.hazelcast.nio.ObjectDataOutput
import com.hazelcast.nio.serialization.StreamSerializer
import com.ryanhuber.hzdemo.hazelcast.IncrementAgeEntryProcessor

class IncrementAgeEntryProcessorSerializer: StreamSerializer<IncrementAgeEntryProcessor> {
    override fun getTypeId(): Int = INCREMENT_AGE_SERIALIZER_ID

    override fun write(output: ObjectDataOutput, entryProcessor: IncrementAgeEntryProcessor) {}

    override fun read(input: ObjectDataInput): IncrementAgeEntryProcessor = IncrementAgeEntryProcessor()
}