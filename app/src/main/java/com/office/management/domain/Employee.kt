package com.office.management.domain

data class Employee(
    val id: String,
    val name: String,
    val role: String,
    val status: EmployeeStatus,
    val lastSeen: String? = null,
    val avatarUrl: String? = null
)

enum class EmployeeStatus {
    ONLINE,
    OFFLINE,
    AWAY
}
