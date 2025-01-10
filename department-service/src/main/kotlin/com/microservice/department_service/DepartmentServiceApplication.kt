package com.microservice.department_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class DepartmentServiceApplication

fun main(args: Array<String>) {
	runApplication<DepartmentServiceApplication>(*args)
}
