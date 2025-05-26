package com.acemdas.migros.locationservice.mapper;

import com.acemdas.migros.locationservice.dto.CourierLocationDto;
import com.acemdas.migros.locationservice.dto.CourierLocationRequestDto;
import com.acemdas.migros.locationservice.dto.CourierLocationResponseDto;
import com.acemdas.migros.locationservice.entity.CourierLocation;
import com.acemdas.migros.locationservice.entity.CourierLocationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierLocationMapper {

    CourierLocation toEntity(CourierLocationRequestDto dto);

    CourierLocationResponseDto toResponseDto(CourierLocation entity);

    List<CourierLocationResponseDto> toResponseDtoList(List<CourierLocation> entities);
}
