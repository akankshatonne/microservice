package com.microservice.department_service.model

data class Employee(val id: Long,
               val departmentId: Long,
               val name: String,
               val age: Int,
               val position: String ) {

}