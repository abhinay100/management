package com.office.management.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.office.management.data.local.dao.EmployeeDao
import com.office.management.data.local.dao.NewsDao
import com.office.management.data.local.dao.UserDao
import com.office.management.data.local.entity.EmployeeEntity
import com.office.management.data.local.entity.NewsEntity
import com.office.management.data.local.entity.UserEntity

/**
 * Created by Abhinay on 29/01/26.
 */

@Database(
    entities = [UserEntity::class, EmployeeEntity::class, NewsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun employeeDao(): EmployeeDao
    abstract fun newsDao(): NewsDao
}



