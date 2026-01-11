package com.office.management.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.office.management.data.local.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abhinay on 11/01/26.
 */
@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employees")
    fun getAllEmployees(): Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM employees WHERE id = :id")
    fun getEmployeeById(id: String): Flow<EmployeeEntity>

    @Query("SELECT * FROM employees WHERE name LIKE '%' || :query || '%'")
    fun searchEmployees(query: String): Flow<List<EmployeeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployees(employees: List<EmployeeEntity>)

    @Delete
    suspend fun deleteEmployee(employee: EmployeeEntity)

    @Query("DELETE FROM employees")
    suspend fun deleteAll()
}