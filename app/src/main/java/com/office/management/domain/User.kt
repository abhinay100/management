package com.office.management.domain

data class User(
    val id: String,
    val username: String,
    val fullName: String,
    val email: String,
    val role: String,
    val token: String? = null
)

