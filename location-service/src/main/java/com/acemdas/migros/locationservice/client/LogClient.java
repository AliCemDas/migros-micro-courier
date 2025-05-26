package com.acemdas.migros.locationservice.client;


import com.acemdas.migros.locationservice.dto.LogRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "log-service")
public interface LogClient {

    @PostMapping("/logs")
    void sendLog(@RequestBody LogRequest request);
}
