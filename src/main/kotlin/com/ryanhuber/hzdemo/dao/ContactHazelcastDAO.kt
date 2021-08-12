package com.ryanhuber.hzdemo.dao

import com.hazelcast.core.HazelcastInstance
import com.hazelcast.map.IMap
import com.hazelcast.query.Predicates
import com.ryanhuber.hzdemo.config.CONTACTS_MAP_NAME
import com.ryanhuber.hzdemo.domain.Contact
import com.ryanhuber.hzdemo.domain.ContactKey
import com.ryanhuber.hzdemo.hazelcast.IncrementAgeEntryProcessor
import org.springframework.stereotype.Component

@Component
class ContactHazelcastDAO(hazelcast: HazelcastInstance) : ContactDAO {
    val contacts: IMap<ContactKey, Contact> = hazelcast.getMap(CONTACTS_MAP_NAME)

    override fun getContact(firstName: String, lastName: String): Contact? = contacts[ContactKey(firstName, lastName)]

    override fun createContact(contact: Contact) {
        contacts[ContactKey(contact.firstName, contact.lastName)] = contact
    }

    override fun findByFirstName(firstName: String): List<Contact> =
        contacts.values(Predicates.equal("firstName", firstName)).toList()

    override fun incrementAge(firstName: String, lastName: String): Contact? =
        contacts.executeOnKey(ContactKey(firstName, lastName), IncrementAgeEntryProcessor())
}