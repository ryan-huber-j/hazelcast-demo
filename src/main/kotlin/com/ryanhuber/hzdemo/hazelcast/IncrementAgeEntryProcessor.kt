package com.ryanhuber.hzdemo.hazelcast

import com.hazelcast.map.EntryProcessor
import com.ryanhuber.hzdemo.domain.Contact
import com.ryanhuber.hzdemo.domain.ContactKey

class IncrementAgeEntryProcessor : EntryProcessor<ContactKey, Contact, Contact> {
    override fun process(entry: MutableMap.MutableEntry<ContactKey, Contact?>): Contact? {
        val contact = entry.value ?: return null
        val newContact = contact.copy(age = contact.age + 1)
        entry.setValue(newContact)
        return newContact
    }
}