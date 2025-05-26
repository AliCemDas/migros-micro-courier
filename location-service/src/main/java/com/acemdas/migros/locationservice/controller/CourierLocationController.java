package com.acemdas.migros.locationservice.controller;

import com.acemdas.migros.locationservice.dto.CourierLocationRequestDto;
import com.acemdas.migros.locationservice.dto.CourierLocationResponseDto;
import com.acemdas.migros.locationservice.service.CourierLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courier-locations")
@RequiredArgsConstructor
public class CourierLocationController {

    private final CourierLocationService courierLocationService;

    @PostMapping
    public ResponseEntity<CourierLocationResponseDto> saveLocation(@RequestBody CourierLocationRequestDto dto) {
        CourierLocationResponseDto response = courierLocationService.saveLocation(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courierId}")
    public ResponseEntity<List<CourierLocationResponseDto>> getLocationsByCourier(@PathVariable Long courierId) {
        List<CourierLocationResponseDto> locations = courierLocationService.getLocationsByCourierId(courierId);
        return ResponseEntity.ok(locations);
    }
}
