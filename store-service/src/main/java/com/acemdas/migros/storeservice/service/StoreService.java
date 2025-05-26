package com.acemdas.migros.storeservice.service;

import com.acemdas.migros.storeservice.dto.StoreRequestDTO;
import com.acemdas.migros.storeservice.dto.StoreResponseDTO;
import com.acemdas.migros.storeservice.entity.Store;

import java.util.List;

public interface StoreService {
    StoreResponseDTO createStore(StoreRequestDTO storeRequestDTO);

    StoreResponseDTO updateStore(Long id, StoreRequestDTO storeRequestDTO);

    void deleteStore(Long id);

    StoreResponseDTO getStoreById(Long id);

    List<StoreResponseDTO> getAllStores();

    List<StoreResponseDTO> getAllActiveStores();
}