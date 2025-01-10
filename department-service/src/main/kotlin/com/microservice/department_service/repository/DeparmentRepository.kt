package com.microservice.department_service.repository

import com.microservice.department_service.model.Department
import org.springframework.stereotype.Repository

@Repository
class DepartmentRepository {
    private val departments = mutableListOf<Department>()

    fun addDepartment(department: Department): Department {
        departments.add(department)
        return department
    }

    fun findById(id: Long): Department {
        return departments.find { it.id == id }
            ?: throw NoSuchElementException("No department found with id $id")
    }

    fun findAll(): List<Department> {
        return departments
    }
}