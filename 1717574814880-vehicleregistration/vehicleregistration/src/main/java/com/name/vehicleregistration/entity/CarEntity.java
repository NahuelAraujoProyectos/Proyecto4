package com.name.vehicleregistration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String brand;
    private String model;
    private Integer milleage;
    private Double price;
    private Integer modelYear;
    private String description;
    private String colour;
    private String fuelType;
    private Integer numDoors;
}
