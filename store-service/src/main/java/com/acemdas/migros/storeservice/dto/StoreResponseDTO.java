package com.acemdas.migros.storeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StoreResponseDTO {
    @Schema(description = "Store Id", example = "1")
    private Long id;

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
}
