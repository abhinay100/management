package com.office.management.di

import com.office.management.data.repository.AuthRepositoryImpl
import com.office.management.data.repository.EmployeeRepositoryImpl
import com.office.management.data.repository.NewsRepositoryImpl
import com.office.management.domain.repository.AuthRepository
import com.office.management.domain.repository.EmployeeRepository
import com.office.management.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Abhinay on 01/02/26.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindEmployeeRepository(
        employeeRepositoryImpl: EmployeeRepositoryImpl
    ): EmployeeRepository

    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository

}