package com.acemdas.migros.storeservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"STORES\"")
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"NAME\"", nullable = false)
    private String name;

    @Column(name = "\"X_COORDINATE\"", nullable = false)
    private Double xCoordinate;

    @Column(name = "\"Y_COORDINATE\"", nullable = false)
    private Double yCoordinate;

    @Column(name = "\"STATUS\"", nullable = false)
    private Boolean status;

    @Column(name = "\"ADDRESS\"", length = 255)
    private String address;

    @Column(name = "\"DESCRIPTION\"", length = 500)
    private String description;
}
