package com.office.management.data.repository

import com.office.management.data.local.dao.EmployeeDao
import com.office.management.data.local.entity.EmployeeEntity
import com.office.management.data.local.entity.toDomain
import com.office.management.domain.Employee
import com.office.management.domain.EmployeeStatus
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
) : EmployeeRepository {
    override suspend fun getEmployees(): Flow<Result<List<Employee>>> = flow {
        try {
            emit(Result.Loading)
            // Check if we have cached data
            val cachedEmployees = employeeDao.getAllEmployees().first()
            if (cachedEmployees.isEmpty()) {
                // Simulate fetching from API and cache
                val mockEmployees = getMockEmployees()
                employeeDao.insertEmployees(mockEmployees)
                emit(Result.Success(mockEmployees.map { it.toDomain() }))
            } else {
                emit(Result.Success(cachedEmployees.map { it.toDomain() }))
            }

        } catch (e: Exception) {
            emit(Result.Error("Failed to get employees: ${e.message}", e))
        }
    }

    override suspend fun searchEmployees(query: String): Flow<Result<List<Employee>>> = flow {
        try {
            emit(Result.Loading)
            val employees = employeeDao.searchEmployees(query).first()
            emit(Result.Success(employees.map { it.toDomain() }))

        } catch (e: Exception) {
            emit(Result.Error("Failed to search employees: ${e.message}", e))
        }
    }

    override suspend fun getEmployeeById(id: String): Flow<Result<Employee>> = flow {
        try {
            emit(Result.Loading)
            val employee = employeeDao.getEmployeeById(id).first()
            if (employee != null) {
                emit(Result.Success(employee.toDomain()))
            } else {
                emit(Result.Error("Employee not found"))
            }

        } catch (e: Exception) {
            emit(Result.Error("Failed to get employee: ${e.message}", e))
        }
    }

    private fun getMockEmployees(): List<EmployeeEntity> {
        return listOf(
            EmployeeEntity(
                id = "1",
                name = "Amber Griffin",
                role = "Online",
                status = EmployeeStatus.ONLINE.name,
                lastSeen = null,
                avatarUrl = null
            ),
            EmployeeEntity(
                id = "2",
                name = "Andreea Wells",
                role = "Online",
                status = EmployeeStatus.ONLINE.name,
                lastSeen = null,
                avatarUrl = null
            ),
            EmployeeEntity(
                id = "3",
                name = "Kathryn Hill",
                role = "Online",
                status = EmployeeStatus.ONLINE.name,
                lastSeen = "Last seen 3 minutes ago",
                avatarUrl = null
            ),
            EmployeeEntity(
                id = "4",
                name = "Kelly McCoy",
                role = "Online",
                status = EmployeeStatus.ONLINE.name,
                lastSeen = "Last seen 5 minutes ago",
                avatarUrl = null
            ),
            EmployeeEntity(
                id = "5",
                name = "Tyler Banks",
                role = "Online",
                status = EmployeeStatus.ONLINE.name,
                lastSeen = "Last seen 7 minutes ago",
                avatarUrl = null
            ),
            EmployeeEntity(
                id = "6",
                name = "Carmen Mendez",
                role = "Online",
                status = EmployeeStatus.ONLINE.name,
                lastSeen = "Last seen 10 minutes ago",
                avatarUrl = null
            )
        )
    }

}