package com.name.vehicleregistration.service.converters;

import com.name.vehicleregistration.model.CarModel;
import com.name.vehicleregistration.model.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    public Car toEntity (CarModel carModel){
        return Car.builder()
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

    public CarModel toModel (Car car){
        return CarModel.builder()
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
}
