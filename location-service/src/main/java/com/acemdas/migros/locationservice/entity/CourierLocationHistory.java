package com.acemdas.migros.locationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "courier_location_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourierLocationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"COURIER_ID\"", nullable = false)
    private Long courierId;


    @Column(name = "\"STORE_ID\"")
    private Long storeId;

    @Column(name = "\"X_COORDINATE\"", nullable = false)
    private Double xCoordinate;

    @Column(name = "\"Y_COORDINATE\"", nullable = false)
    private Double yCoordinate;

    @Column(name = "\"ENTERED_AT\"", nullable = false)
    private LocalDateTime enteredAt;

    @PrePersist
    protected void onCreate() {
        enteredAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        enteredAt = LocalDateTime.now();
    }
}
