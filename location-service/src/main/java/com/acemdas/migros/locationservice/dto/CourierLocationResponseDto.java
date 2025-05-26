package com.acemdas.migros.locationservice.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierLocationResponseDto {
    private Long id;
    private Long courierId;
    private LocalDateTime timestamp;
    private Double xCoordinate;
    private Double yCoordinate;
}
