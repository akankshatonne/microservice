package com.microservice.employee_service.controller

import com.microservice.employee_service.model.Employee
import com.microservice.employee_service.repository.EmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employee")
class EmployeeController(
    private val repository: EmployeeRepository
) {
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(EmployeeController::class.java)
    }

    @PostMapping
    fun add(@RequestBody employee: Employee): Employee {
        LOGGER.info("Employee add: {}", employee)
        return repository.addEmployee(employee)
    }

    @GetMapping
    fun findAll(): List<Employee> {
        LOGGER.info("Employee find")
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Employee {
        LOGGER.info("Employee find: id={}", id)
        return repository.findById(id)
    }

    @GetMapping("/department/{departmentId}")
    fun findByDepartment(@PathVariable departmentId: Long): List<Employee> {
        LOGGER.info("Employee find: departmentId={}", departmentId)
        return repository.findEmployeeByDepartmentId(departmentId)
    }
}