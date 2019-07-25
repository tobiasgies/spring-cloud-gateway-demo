package de.tobiasgies.inventory

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/inventory")
class InventoryController {
    @GetMapping("/hello")
    fun hello() = Mono.just("Hello from the inventory controller!\n")
}