package com.office.management.domain.repository

import com.office.management.domain.User
import kotlinx.coroutines.flow.Flow
import com.office.management.domain.common.Result

/**
 * Created by Abhinay on 08/01/26.
 */

interface AuthRepository {
    suspend fun login(userName: String, password: String): Flow<Result<User>>
    suspend fun logout(): Flow<Result<Unit>>
    suspend fun getCurrentUser(): Flow<Result<User>>
    suspend fun isLoggedIn(): Boolean
}