package com.acemdas.migros.courierservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"COURIERS\"")
@Getter
@Setter
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"NAME\"", nullable = false)
    private String name;

    @Column(name = "\"PHONE_NUMBER\"", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "\"CURRENT_X\"", nullable = false)
    private Double currentX;

    @Column(name = "\"CURRENT_Y\"", nullable = false)
    private Double currentY;

    @Column(name = "\"STATUS\"", nullable = false)
    private Boolean status;

    @Column(name = "\"LAST_UPDATED\"")
    private LocalDateTime lastUpdated;

    @PrePersist
    protected void onCreate() {
        lastUpdated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}