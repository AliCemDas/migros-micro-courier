package com.acemdas.migros.courierservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierRequestDto {
    private String name;
    private String phoneNumber;
    private Boolean active;
    private Double xCoordinate;
    private Double yCoordinate;
}
