package com.acemdas.migros.courierservice.service.impl;

import com.acemdas.migros.courierservice.dto.CourierRequestDto;
import com.acemdas.migros.courierservice.dto.CourierResponseDto;
import com.acemdas.migros.courierservice.entity.Courier;
import com.acemdas.migros.courierservice.mapper.CourierMapper;
import com.acemdas.migros.courierservice.repository.CourierRepository;
import com.acemdas.migros.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    @Override
    public CourierResponseDto createCourier(CourierRequestDto dto) {
        Courier courier = courierMapper.toEntity(dto);
        Courier savedCourier = courierRepository.save(courier);
        return courierMapper.toDto(savedCourier);
    }

    @Override
    public CourierResponseDto updateCourier(Long id, CourierRequestDto dto) {
        Courier existing = courierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Courier not found with id: " + id));

        Courier updatedCourier = courierMapper.toEntity(dto);
        updatedCourier.setId(id);

        Courier updated = courierRepository.save(updatedCourier);
        return courierMapper.toDto(updated);
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }

    @Override
    public CourierResponseDto getCourierById(Long id) {
        Courier courier = courierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Courier not found with id: " + id));
        return courierMapper.toDto(courier);
    }

    @Override
    public List<CourierResponseDto> getAllCouriers() {
        List<Courier> couriers = courierRepository.findAll();
        return courierMapper.toDtoList(couriers);
    }
}
