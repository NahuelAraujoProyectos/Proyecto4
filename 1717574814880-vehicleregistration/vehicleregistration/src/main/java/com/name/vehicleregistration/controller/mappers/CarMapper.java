package com.name.vehicleregistration.controller.mappers;

import com.name.vehicleregistration.model.Car;
import com.name.vehicleregistration.controller.dtos.CarRequest;
import com.name.vehicleregistration.controller.dtos.CarResponse;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarResponse toResponse (Car car){
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .milleage(car.getMilleage())
                .price(car.getPrice())
                .modelYear(car.getModelYear())
                .description(car.getDescription())
                .colour(car.getColour())
                .fuelType(car.getFuelType())
                .numDoors(car.getNumDoors())
                .build();
    }

    public Car toModel (CarRequest carRequest){
        return Car.builder()
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
