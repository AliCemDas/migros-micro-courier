package com.acemdas.migros.courierservice.controller;

import com.acemdas.migros.courierservice.dto.CourierRequestDto;
import com.acemdas.migros.courierservice.dto.CourierResponseDto;
import com.acemdas.migros.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @PostMapping
    public ResponseEntity<CourierResponseDto> createCourier(@RequestBody CourierRequestDto dto) {
        CourierResponseDto response = courierService.createCourier(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourierResponseDto> updateCourier(@PathVariable Long id, @RequestBody CourierRequestDto dto) {
        CourierResponseDto response = courierService.updateCourier(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourier(@PathVariable Long id) {
        courierService.deleteCourier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourierResponseDto> getCourierById(@PathVariable Long id) {
        CourierResponseDto response = courierService.getCourierById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CourierResponseDto>> getAllCouriers() {
        List<CourierResponseDto> list = courierService.getAllCouriers();
        return ResponseEntity.ok(list);
    }
}
