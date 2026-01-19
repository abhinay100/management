package com.office.management.data.repository

import com.office.management.data.local.dao.EmployeeDao
import com.office.management.domain.Employee
import com.office.management.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.office.management.domain.common.Result
import kotlinx.coroutines.flow.first

/**
 * Created by Abhinay on 19/01/26.
 */
class EmployeeRepositoryImpl @Inject constructor(
    private val employeeDao: EmployeeDao
): EmployeeRepository {
    override suspend fun getEmployees(): Flow<Result<List<Employee>>> = flow {
          try {
              emit(Result.Loading)
              // Check if we have cached data
              val cachedEmployees = employeeDao.getAllEmployees().first()
              if(cachedEmployees.isEmpty()) {
                  // Simulate fetching from API and cache
                  val mockEmployees = getMockEmployees()
                  employeeDao.insertEmployees(mockEmployees)
                  emit(Result.Success(mockEmployees.map {it.toDomain()}))
              }else {
                  emit(Result.Success(cachedEmployees.map { it.toDomain() }))
              }

          } catch (e: Exception) {
              emit(Result.Error("Failed to get employees: ${e.message}", e))
          }
    }

    override suspend fun searchEmployees(): Flow<Result<List<Employee>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEmployeeById(): Flow<Result<List<Employee>>> {
        TODO("Not yet implemented")
    }

}