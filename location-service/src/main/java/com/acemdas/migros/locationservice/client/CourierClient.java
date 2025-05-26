package com.acemdas.migros.locationservice.client;


import com.acemdas.migros.locationservice.dto.CourierResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "courier-service")
public interface CourierClient {

    @GetMapping("/api/couriers/{id}")
    CourierResponseDto getCourierById(@PathVariable("id") Long id);
}