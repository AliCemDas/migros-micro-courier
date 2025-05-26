package com.acemdas.migros.storeservice.controller;

import com.acemdas.migros.storeservice.dto.StoreRequestDTO;
import com.acemdas.migros.storeservice.dto.StoreResponseDTO;
import com.acemdas.migros.storeservice.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @Operation(summary = "Create Store")
    @PostMapping
    public ResponseEntity<StoreResponseDTO> createStore(@RequestBody StoreRequestDTO storeRequestDTO) {
        StoreResponseDTO responseDTO = storeService.createStore(storeRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Update Store")
    @PutMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> updateStore(@PathVariable Long id,
                                                        @RequestBody StoreRequestDTO storeRequestDTO) {
        StoreResponseDTO responseDTO = storeService.updateStore(id, storeRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Delete Store")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Get Store By Id")
    @GetMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> getStoreById(@PathVariable Long id) {
        StoreResponseDTO responseDTO = storeService.getStoreById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "List All Stores")
    @GetMapping
    public ResponseEntity<List<StoreResponseDTO>> getAllStores() {
        List<StoreResponseDTO> responseDTOList = storeService.getAllStores();
        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/active")
    public List<StoreResponseDTO> getAllActiveStores() {
        return storeService.getAllActiveStores();
    }
}
