package com.office.management.domain.repository

import com.office.management.domain.Employee
import kotlinx.coroutines.flow.Flow
import com.office.management.domain.common.Result

/**
 * Created by Abhinay on 08/01/26.
 */

interface EmployeeRepository {
    suspend fun getEmployees(): Flow<Result<List<Employee>>>
    suspend fun searchEmployees(query: String): Flow<Result<List<Employee>>>
    suspend fun getEmployeeById(id: String): Flow<Result<Employee>>
}