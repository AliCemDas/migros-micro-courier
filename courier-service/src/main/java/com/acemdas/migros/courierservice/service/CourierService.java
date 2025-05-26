package com.acemdas.migros.courierservice.service;

import com.acemdas.migros.courierservice.dto.CourierRequestDto;
import com.acemdas.migros.courierservice.dto.CourierResponseDto;

import java.util.List;

public interface CourierService {
    CourierResponseDto createCourier(CourierRequestDto dto);

    CourierResponseDto updateCourier(Long id, CourierRequestDto dto);

    void deleteCourier(Long id);

    CourierResponseDto getCourierById(Long id);

    List<CourierResponseDto> getAllCouriers();
}
