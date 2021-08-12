package com.ryanhuber.hzdemo.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class ContactKey(val firstName: String, val lastName: String)

data class Contact(
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_name") val lastName: String,
    @JsonProperty("phone_number") val phoneNumber: String,
    @JsonProperty("address") val address: String,
    @JsonProperty("age") val age: Int
)