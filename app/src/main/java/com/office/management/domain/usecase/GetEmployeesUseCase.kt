package com.office.management.domain.usecase

import com.office.management.domain.Employee
import com.office.management.domain.common.Result
import com.office.management.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Abhinay on 08/01/26.
 */

class GetEmployeesUseCase @Inject constructor(
     private val employeeRepository: EmployeeRepository
) {
    suspend operator fun invoke(): Flow<Result<List<Employee>>> {
        return employeeRepository.getEmployees()
    }

}