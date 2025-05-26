package com.acemdas.migros.gatewayservice.client;

import com.acemdas.migros.gatewayservice.dto.TokenValidationRequest;
import com.acemdas.migros.gatewayservice.dto.TokenValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", path = "/auth")
public interface AuthClient {

    @PostMapping("/validate")
    TokenValidationResponse validate(@RequestHeader("Authorization") String token);
}