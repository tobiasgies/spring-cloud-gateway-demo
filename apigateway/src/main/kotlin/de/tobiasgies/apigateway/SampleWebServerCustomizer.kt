package de.tobiasgies.apigateway

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

/**
 * Customize the underlying Netty web server.
 *
 * If the factory itself does not expose a customization option, it is possible to manipulate the
 * [reactor.netty.http.server.HttpServer] directly by using [NettyReactiveWebServerFactory.addServerCustomizers].
 */
@Component
class SampleWebServerCustomizer :
    WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    override fun customize(factory: NettyReactiveWebServerFactory) {
        // For example: customize TLS settings here
        // factory.ssl = Ssl()
        // side note: One could use netty-tcnative and its OpenSSL bindings as well.
    }
}