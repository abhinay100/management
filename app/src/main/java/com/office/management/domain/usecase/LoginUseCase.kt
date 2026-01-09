package com.office.management.domain.usecase

import com.office.management.domain.User
import com.office.management.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.office.management.domain.common.Result
import javax.inject.Inject

/**
 * Created by Abhinay on 08/01/26.
 */

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(userName: String, password: String): Flow<Result<User>> {
        if(userName.isBlank()) {
            return flow {
                emit(Result.Error("Username cannot be empty"))
            }
        }

        if(password.isBlank()) {
            return flow {
                emit(Result.Error("Password cannot be empty"))
            }
        }

        return authRepository.login(userName, password)

    }

}