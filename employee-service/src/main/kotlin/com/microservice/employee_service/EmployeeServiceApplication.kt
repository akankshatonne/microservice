package com.microservice.employee_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class EmployeeServiceApplication

fun main(args: Array<String>) {
	runApplication<EmployeeServiceApplication>(*args)
}
