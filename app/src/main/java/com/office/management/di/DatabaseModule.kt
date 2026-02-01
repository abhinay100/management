package com.office.management.di

import android.content.Context
import androidx.room.Room
import com.office.management.data.local.AppDatabase
import com.office.management.data.local.dao.EmployeeDao
import com.office.management.data.local.dao.NewsDao
import com.office.management.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Abhinay on 27/01/26.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "office_management_db"
        ).build()

    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideEmployeeDao(database: AppDatabase): EmployeeDao {
        return database.employeeDao()
    }

    @Provides
    @Singleton
    fun provideNewsDao(database: AppDatabase): NewsDao {
        return database.newsDao()
    }

}