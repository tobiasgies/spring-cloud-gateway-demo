package de.tobiasgies.apigateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/local_endpoints")
@RestController
class LocalEndpoints {
    @GetMapping("/go_away")
    fun goAway() = Mono.just("Go away, Apple has no place in this household!")
}