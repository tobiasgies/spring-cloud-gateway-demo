package de.tobiasgies.bouquet

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/bouquet")
class BouquetController {
    @GetMapping("/hello")
    fun hello() = Mono.just("Hello from the bouquet controller!\n")
}