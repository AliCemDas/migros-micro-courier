package com.acemdas.migros.gatewayservice.filter;

import com.acemdas.migros.gatewayservice.client.AuthClient;
import com.acemdas.migros.gatewayservice.dto.TokenValidationResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;

@Component
@RequiredArgsConstructor
public class AuthFilter implements GatewayFilter {

    private final @Lazy AuthClient authClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        // Auth servis yolları için filtrelemeyi atla
        if (StringUtils.isEmpty(path) &&
                (path.startsWith("/api/auth/login") || path.startsWith("/api/auth/validate"))) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        try {
            TokenValidationResponse response = authClient.validate(token);

            if (response.isValid()) {
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

    }


}
