package com.office.management.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.office.management.domain.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val username: String,
    val fullName: String,
    val email: String,
    val role: String,
    val token: String?
)

fun UserEntity.toDomain() : User {
    return User(
        id = id,
        username = username,
        fullName = fullName,
        email = email,
        role = role,
        token = token
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        username = username,
        fullName = fullName,
        email = email,
        role = role,
        token = token
    )
}
