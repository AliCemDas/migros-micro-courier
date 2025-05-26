package com.acemdas.migros.locationservice.dto;

import lombok.Data;

@Data
public class StoreRequestDTO {

    private String name;
    private Double xCoordinate;
    private Double yCoordinate;
    private Boolean status;
    private String address;
    private String description;
}
