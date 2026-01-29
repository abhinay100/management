package com.office.management.data.repository

import com.office.management.data.local.dao.UserDao
import com.office.management.data.local.entity.toDomain
import com.office.management.data.local.entity.toEntity
import com.office.management.domain.User
import com.office.management.domain.common.Result
import com.office.management.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Abhinay on 29/01/26.
 */
class AuthRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): AuthRepository {
    override suspend fun login(
        userName: String,
        password: String
    ): Flow<Result<User>> = flow {
        try {
            emit(Result.Loading)
            // Simulating API call - In real app, call API here
            kotlinx.coroutines.delay(1000)
            // Mock validation
            if (userName == "demo" && password == "password") {
                val user = User(
                    id = "1",
                    username = userName,
                    fullName = "Samantha William",
                    email = "samantha@office.com",
                    role = "Manager",
                    token = "mock_token_${System.currentTimeMillis()}"

                )
                // Save to local database
                userDao.insertUser(user.toEntity())
                emit(Result.Success(user))
            } else {
                emit(Result.Error("Invalid username or password"))
            }

        }catch (e : Exception) {
            emit(Result.Error("Login failed: ${e.message}", e))
        }

    }

    override suspend fun logout(): Flow<Result<Unit>> = flow {
       try {
           emit(Result.Loading)
           userDao.deleteAll()
           emit(Result.Success(Unit))
       } catch (e : Exception) {
           emit(Result.Error("Logout failed: ${e.message}", e))
       }
    }

    override suspend fun getCurrentUser(): Flow<Result<User?>> = flow {
        try {
            val userEntity = userDao.getCurrentUser().first()
            if (userEntity != null) {
                emit(Result.Success(userEntity.toDomain()))
            } else {
                emit(Result.Success(null))
            }
        } catch (e: Exception) {
            emit(Result.Error("Failed to get user: ${e.message}", e))
        }
    }

    override suspend fun isLoggedIn(): Boolean {
        return userDao.getUserCount() > 0
    }

}