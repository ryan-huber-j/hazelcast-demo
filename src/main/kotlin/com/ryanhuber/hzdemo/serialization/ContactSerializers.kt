package com.ryanhuber.hzdemo.serialization

import com.hazelcast.nio.ObjectDataInput
import com.hazelcast.nio.ObjectDataOutput
import com.hazelcast.nio.serialization.StreamSerializer
import com.ryanhuber.hzdemo.domain.Contact
import com.ryanhuber.hzdemo.domain.ContactKey
import org.springframework.stereotype.Component

@Component
class ContactKeySerializer : StreamSerializer<ContactKey> {
    override fun getTypeId(): Int = CONTACT_KEY_TYPE_ID

    override fun write(output: ObjectDataOutput, key: ContactKey) {
        output.writeString(key.firstName)
        output.writeString(key.lastName)
    }

    override fun read(input: ObjectDataInput): ContactKey {
        val firstName = input.readString()!!
        val lastName = input.readString()!!

        return ContactKey(firstName, lastName)
    }
}

@Component
class ContactSerializer : StreamSerializer<Contact> {
    override fun getTypeId(): Int = CONTACT_TYPE_ID

    override fun write(output: ObjectDataOutput, contact: Contact) {
        with(contact) {
            output.writeString(firstName)
            output.writeString(lastName)
            output.writeString(phoneNumber)
            output.writeString(address)
            output.writeInt(age)
        }
    }

    override fun read(input: ObjectDataInput): Contact {
        val firstName = input.readString()!!
        val lastName = input.readString()!!
        val phoneNumber = input.readString()!!
        val address = input.readString()!!
        val age = input.readInt()

        return Contact(firstName, lastName, phoneNumber, address, age)
    }
}