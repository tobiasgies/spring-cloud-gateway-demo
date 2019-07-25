package de.tobiasgies.apigateway

import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

/**
 * Filters are available in per-route and global versions.
 *
 * [@Components][Component] that implement [GlobalFilter] are automatically added to the global filter chain. Their
 * order of execution can be influenced using [@Ordered][org.springframework.core.Ordered].
 *
 * BEWARE: Filtering happens after routing. You cannot influence routing decisions in any way using filters. That's what
 * [Route Predicates][java.util.function.Predicate] are for.
 */
@Component
class SampleGlobalFilter : GlobalFilter {
    override fun filter(exchange: ServerWebExchange?, chain: GatewayFilterChain): Mono<Void> {
        // Do something interesting with the request, e.g. manipulate the exchange.
        // Afterwards, pass the request on to the next filter in the chain:
        return chain.filter(exchange)
    }

}