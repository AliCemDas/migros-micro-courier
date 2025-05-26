package com.acemdas.migros.courierservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CourierResponseDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Boolean status;
    private Double currentX;
    private Double currentY;
    private LocalDateTime lastUpdated;
}
