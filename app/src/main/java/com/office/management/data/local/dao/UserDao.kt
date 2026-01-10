package com.office.management.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.office.management.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abhinay on 10/01/26.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM users LIMIT 1")
    fun getCurrentUser(): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM users")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount():Int
}