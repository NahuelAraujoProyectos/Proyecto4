package com.name.vehicleregistration.model.dtos;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private Integer id;
    private String brand;
    private String model;
    private Integer milleage;
    private Double price;
    private Integer model_year;
    private String description;
    private String colour;
    private String fuelType;
    private Integer numDoors;
}
