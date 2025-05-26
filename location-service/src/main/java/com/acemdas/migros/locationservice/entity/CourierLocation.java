package com.acemdas.migros.locationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "COURIER_LOCATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CourierLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COURIER_ID", nullable = false)
    private Long courierId;

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "X_COORDINATE", nullable = false)
    private Double xCoordinate;

    @Column(name = "Y_COORDINATE", nullable = false)
    private Double yCoordinate;

}
