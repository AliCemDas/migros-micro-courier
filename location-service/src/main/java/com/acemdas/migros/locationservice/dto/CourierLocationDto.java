package com.acemdas.migros.locationservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CourierLocationDto {
    private Long id;
    private Long courierId;
    private Long storeId;
    private Double xCoordinate;
    private Double yCoordinate;
    private LocalDateTime enteredAt;
}
