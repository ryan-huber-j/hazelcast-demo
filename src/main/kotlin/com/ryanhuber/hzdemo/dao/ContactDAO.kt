package com.ryanhuber.hzdemo.dao

import com.ryanhuber.hzdemo.domain.Contact

interface ContactDAO {
    fun getContact(firstName: String, lastName: String): Contact?

    fun createContact(contact: Contact)

    fun findByFirstName(firstName: String): List<Contact>

    fun incrementAge(firstName: String, lastName: String): Contact?
}