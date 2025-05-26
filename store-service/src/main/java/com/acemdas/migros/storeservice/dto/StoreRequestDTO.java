package com.acemdas.migros.storeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


public class StoreRequestDTO {

    @Schema(description = "Store Name", example = "Migros Kanyon")
    private String name;

    @Schema(description = "Store X Coordinate", example = "41.025")
    private Double xCoordinate;

    @Schema(description = "Store Y Coordinate", example = "41.025")
    private Double yCoordinate;

    @Schema(description = "Store Active or Passive Status", example = "true")
    private Boolean status;

    @Schema(description = "Store Address Info", example = "Kanyon Avm, Levent, İstanbul ")
    private String address;

    @Schema(description = "Store Description", example = "İstanbul Bölge Bayii")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
