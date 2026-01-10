package com.office.management.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.office.management.domain.Employee
import com.office.management.domain.EmployeeStatus

@Entity(tableName = "employees")
data class EmployeeEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val role: String,
    val status: String,
    val lastSeen: String?,
    val avatarUrl: String?
)

fun EmployeeEntity.toDomain(): Employee {
    return Employee(
        id = id,
        name = name,
        role = role,
        status = EmployeeStatus.valueOf(status),
        lastSeen = lastSeen,
        avatarUrl = avatarUrl
    )
}

fun Employee.toEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        name = name,
        role = role,
        status = status.name,
        lastSeen = lastSeen,
        avatarUrl = avatarUrl
    )
}
