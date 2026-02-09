package com.office.management.domain.usecase

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat

import com.office.management.domain.repository.AuthRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import com.office.management.domain.common.Result

/**
 * Created by Abhinay on 09/02/26.
 */

class LoginUseCaseTest {

    private lateinit var loginUseCase: LoginUseCase
    private lateinit var authRepository: AuthRepository

    @Before
    fun setup(){
        authRepository = mock()
        loginUseCase = LoginUseCase(authRepository)
    }

    @Test
    fun `empty username returns error`() = runTest {
        loginUseCase("","password").test{
            val result = awaitItem()
            assertThat(result).isInstanceOf(Result.Error::class.java)
            assertThat((result as Result.Error).message).isEqualTo("Username cannot be empty")
            awaitComplete()
        }

    }


}