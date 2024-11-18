package com.MS_gateway.MS.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyCustomFilter implements GlobalFilter {
    private static final String ORIGIN_HEADER = "http://localhost:8089";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
        exchange.getRequest().mutate().headers(httpHeaders -> {
            httpHeaders.set(HttpHeaders.ORIGIN, ORIGIN_HEADER);
        }).build();
        return chain.filter(exchange);
    }

}
