package com.ryanhuber.hzdemo.controller

import com.ryanhuber.hzdemo.domain.Contact
import com.ryanhuber.hzdemo.repository.ContactRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contacts")
class ContactController(val repository: ContactRepository) {
    @GetMapping
    fun getContact(
        @RequestParam("first_name") firstName: String,
        @RequestParam("last_name") lastName: String
    ): Contact? =
        repository.getContact(firstName, lastName)

    @PutMapping
    fun createContact(@RequestBody contact: Contact) = repository.createContact(contact)

    @GetMapping("/search/{firstName}")
    fun getContactsByFirstName(@PathVariable firstName: String): List<Contact> = repository.findContactsByFirstName(firstName)

    @PostMapping("/incrementAge")
    fun incrementAge(
        @RequestParam("first_name") firstName: String,
        @RequestParam("last_name") lastName: String
    ): Contact? =
        repository.incrementAge(firstName, lastName)
}