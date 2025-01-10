package com.microservice.department_service.controller

import com.microservice.department_service.client.EmployeeClient
import com.microservice.department_service.model.Department
import com.microservice.department_service.repository.DepartmentRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/department")
class DepartmentController(
     private val repository: DepartmentRepository,
     private val employeeClient: EmployeeClient
) {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(DepartmentController::class.java)
    }

    @PostMapping
    fun add(@RequestBody department: Department): Department {
        LOGGER.info("Department add: {}", department)
        return repository.addDepartment(department)
    }

    @GetMapping
    fun findAll(): List<Department> {
        LOGGER.info("Find all Departments")
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Department {
        LOGGER.info("Department find by ID: id={}", id)
        return repository.findById(id)
    }

    @GetMapping("/with-employees")
    fun findAllWithEmployees(): List<Department> {
        LOGGER.info("Department find with employees")
        return repository.findAll().onEach { department ->
            department.employeeList = employeeClient.findByDepartment(department.id)
        }
    }
}