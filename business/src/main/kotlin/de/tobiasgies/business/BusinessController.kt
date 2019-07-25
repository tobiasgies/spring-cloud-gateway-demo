package de.tobiasgies.business

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/business")
class BusinessController {
    @GetMapping("/hello")
    fun hello() = Mono.just("Hello from the business controller!\n")
}