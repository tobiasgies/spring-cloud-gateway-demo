package de.tobiasgies.apigateway

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RoutingConfiguration {
    @Bean
    fun routingDefinition(builder: RouteLocatorBuilder) = builder.routes { 
        route(id = "bouquet_microservice", order = 1) {
            path("/bouquet/*")
            uri("http://localhost:8091")
        }
        route(id = "business_microservice", order = 2) {
            path("/business/*")
            uri("http://localhost:8092")
        }
        route(id = "inventory_microservice", order = 3) {
            path("/inventory/*")
            uri("http://localhost:8093")
        }
        route(id = "catchall", order = 10) {
            alwaysTrue()
            uri("forward:/local_endpoints/go_away")
        }
    }
}

