package com.acemdas.migros.storeservice.service.impl;

import com.acemdas.migros.storeservice.dto.StoreRequestDTO;
import com.acemdas.migros.storeservice.dto.StoreResponseDTO;
import com.acemdas.migros.storeservice.entity.Store;
import com.acemdas.migros.storeservice.mapper.StoreMapper;
import com.acemdas.migros.storeservice.repository.StoreRepository;
import com.acemdas.migros.storeservice.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public StoreResponseDTO createStore(StoreRequestDTO storeRequestDTO) {
        Store store = storeMapper.toEntity(storeRequestDTO);
        Store savedStore = storeRepository.save(store);
        return storeMapper.toDto(savedStore);
    }

    @Override
    public StoreResponseDTO updateStore(Long id, StoreRequestDTO storeRequestDTO) {
        Store existingStore = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id " + id));

        Store updatedStore = storeMapper.toEntity(storeRequestDTO);
        updatedStore.setId(id);

        Store savedStore = storeRepository.save(updatedStore);
        return storeMapper.toDto(savedStore);
    }

    @Override
    public void deleteStore(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id " + id));
        storeRepository.delete(store);
    }

    @Override
    public StoreResponseDTO getStoreById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id " + id));
        return storeMapper.toDto(store);
    }

    @Override
    public List<StoreResponseDTO> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return storeMapper.toDtoList(stores);
    }

    @Override
    public List<StoreResponseDTO> getAllActiveStores() {
        List<Store> byStatusTrue = storeRepository.findByStatusTrue();
        return storeMapper.toDtoList(byStatusTrue);
    }
}
