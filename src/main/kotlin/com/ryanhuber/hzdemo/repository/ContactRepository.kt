package com.ryanhuber.hzdemo.repository

import com.ryanhuber.hzdemo.dao.ContactDAO
import com.ryanhuber.hzdemo.domain.Contact
import com.ryanhuber.hzdemo.domain.ContactKey
import org.springframework.stereotype.Repository

@Repository
class ContactRepository(private val dao: ContactDAO) {
    fun getContact(firstName: String, lastName: String): Contact? = dao.getContact(firstName, lastName)

    fun createContact(contact: Contact) = dao.createContact(contact)

    fun findContactsByFirstName(firstName: String) = dao.findByFirstName(firstName)

    fun incrementAge(firstName: String, lastName: String): Contact? = dao.incrementAge(firstName, lastName)
}