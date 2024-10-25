package com.name.vehicleregistration.model;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {
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
