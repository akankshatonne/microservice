package com.microservice.department_service.config

import com.microservice.department_service.client.EmployeeClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class WebClientConfig {

    @Autowired
    private lateinit var filterFunction: LoadBalancedExchangeFilterFunction

    @Bean
    fun employeeWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl("http://employee-service")
            .filter(filterFunction)
            .build();
    }

    @Bean
    fun employeeClient(): EmployeeClient {
        val wca = WebClientAdapter.create(employeeWebClient())
        val httpServiceProxyFactory: HttpServiceProxyFactory = HttpServiceProxyFactory.builderFor(wca).build()
        return httpServiceProxyFactory.createClient(EmployeeClient::class.java)
    }

}