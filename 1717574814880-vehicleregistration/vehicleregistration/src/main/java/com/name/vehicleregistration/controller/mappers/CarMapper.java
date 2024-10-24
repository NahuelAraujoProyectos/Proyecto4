package com.name.vehicleregistration.controller.mappers;

import com.name.vehicleregistration.model.CarModel;
import com.name.vehicleregistration.model.dtos.CarRequest;
import com.name.vehicleregistration.model.dtos.CarResponse;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarResponse toResponse (CarModel carModel){
        return CarResponse.builder()
                .id(carModel.getId())
                .brand(carModel.getBrand())
                .model(carModel.getModel())
                .milleage(carModel.getMilleage())
                .price(carModel.getPrice())
                .modelYear(carModel.getModelYear())
                .description(carModel.getDescription())
                .colour(carModel.getColour())
                .fuelType(carModel.getFuelType())
                .numDoors(carModel.getNumDoors())
                .build();
    }

    public CarModel toModel (CarRequest carRequest){
        return CarModel.builder()
                .brand(carRequest.getBrand())
                .model(carRequest.getModel())
                .milleage(carRequest.getMilleage())
                .price(carRequest.getPrice())
                .modelYear(carRequest.getModelYear())
                .description(carRequest.getDescription())
                .colour(carRequest.getColour())
                .fuelType(carRequest.getFuelType())
                .numDoors(carRequest.getNumDoors())
                .build();
    }
}
