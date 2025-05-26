package com.acemdas.migros.locationservice.service;

import com.acemdas.migros.locationservice.dto.CourierLocationDto;
import com.acemdas.migros.locationservice.dto.CourierLocationRequestDto;
import com.acemdas.migros.locationservice.dto.CourierLocationResponseDto;

import java.util.List;

public interface CourierLocationService {

    CourierLocationResponseDto saveLocation(CourierLocationRequestDto dto);

    List<CourierLocationResponseDto> getLocationsByCourierId(Long courierId);


    void processCourierLocation(CourierLocationDto dto);
}
