package com.name.vehicleregistration.service.converters;

import com.name.vehicleregistration.model.Car;
import com.name.vehicleregistration.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    public CarEntity toEntity (Car car){
        return CarEntity.builder()
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

    public Car toModel (CarEntity carEntity){
        return Car.builder()
                .id(carEntity.getId())
                .brand(carEntity.getBrand())
                .model(carEntity.getModel())
                .milleage(carEntity.getMilleage())
                .price(carEntity.getPrice())
                .modelYear(carEntity.getModelYear())
                .description(carEntity.getDescription())
                .colour(carEntity.getColour())
                .fuelType(carEntity.getFuelType())
                .numDoors(carEntity.getNumDoors())
                .build();
    }
}
