package akal.nari.kolaborasi.config

import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class customwebfilter : WebFilter {
  override fun filter(p0: ServerWebExchange, p1: WebFilterChain): Mono<Void> {
    if (p0.request.uri.path.equals("/")) {
      return p1.filter(p0.mutate().request(p0.request.mutate().path("/index.html").build()).build())
    }
    return p1.filter(p0)
  }
}