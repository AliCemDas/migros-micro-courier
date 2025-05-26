package com.acemdas.migros.locationservice.client;


import com.acemdas.migros.locationservice.dto.StoreResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "store-service")
public interface StoreClient {

    @GetMapping("/api/stores/active")
    List<StoreResponseDTO> getAllActiveStores();
}
