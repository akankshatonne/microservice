package com.microservice.department_service.model

data class Department(
    val id: Long,
    val name: String,
    var employeeList: List<Employee> = emptyList()
)