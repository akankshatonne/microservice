package com.microservice.employee_service.model

data class Employee(val id: Long,
               val departmentId: Long? = null,
               val name: String,
               val age: Int,
               val position: String ) {

}