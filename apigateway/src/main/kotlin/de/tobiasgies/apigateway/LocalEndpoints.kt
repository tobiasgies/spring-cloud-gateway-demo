package de.tobiasgies.apigateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/local_endpoints")
@RestController
class LocalEndpoints {
    @GetMapping("/go_away")
    fun goAway() = Mono.just("Go away, you don't know how to use my API.\n")
}