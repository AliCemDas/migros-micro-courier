package com.acemdas.migros.storeservice.mapper;

import com.acemdas.migros.storeservice.dto.StoreRequestDTO;
import com.acemdas.migros.storeservice.dto.StoreResponseDTO;
import com.acemdas.migros.storeservice.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    StoreResponseDTO toDto(Store store);

    Store toEntity(StoreRequestDTO dto);

    List<StoreResponseDTO> toDtoList(List<Store> stores);
}
