package com.microservice.department_service.client

import com.microservice.department_service.model.Employee
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

@HttpExchange
interface EmployeeClient {

    @GetExchange("/employee/department/{departmentId}")
    fun findByDepartment(@PathVariable departmentId: Long): List<Employee>;
}