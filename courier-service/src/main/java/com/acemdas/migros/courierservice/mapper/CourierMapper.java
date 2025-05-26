package com.acemdas.migros.courierservice.mapper;

import com.acemdas.migros.courierservice.dto.CourierRequestDto;
import com.acemdas.migros.courierservice.dto.CourierResponseDto;
import com.acemdas.migros.courierservice.entity.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierMapper {

    CourierResponseDto toDto(Courier courier);

    Courier toEntity(CourierRequestDto dto);

    List<CourierResponseDto> toDtoList(List<Courier> couriers);
}
