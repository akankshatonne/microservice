package com.microservice.employee_service.repository

import com.microservice.employee_service.model.Employee
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository {
    private val employees = mutableListOf<Employee>()

    fun addEmployee(department: Employee): Employee {
        employees.add(department)
        return department
    }

    fun findById(id: Long): Employee {
        return employees.find { it.id == id }
            ?: throw NoSuchElementException("No department found with id $id")
    }

    fun findAll(): List<Employee> {
        return employees
    }

    fun findEmployeeByDepartmentId(departmentId: Long): List<Employee> {
        return employees.filter { it.departmentId == departmentId }
    }
}