package com.name.vehicleregistration.service;

import com.name.vehicleregistration.model.CarModel;
import com.name.vehicleregistration.model.entity.Car;

import java.util.Optional;

public interface CarService {
    private Optional<Car> getCar(Integer id){
        return Optional.empty();
    };

    public  CarModel addCar(CarModel carModel);
    public CarModel getCarById(Integer id);
    public CarModel updateCar(Integer id, CarModel carModel);
    public CarModel deleteById(Integer id);
}
