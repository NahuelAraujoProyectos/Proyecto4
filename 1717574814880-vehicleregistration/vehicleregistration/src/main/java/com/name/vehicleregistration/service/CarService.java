package com.name.vehicleregistration.service;

import com.name.vehicleregistration.controller.dtos.CarRequest;
import com.name.vehicleregistration.controller.dtos.CarResponse;
import com.name.vehicleregistration.model.Car;


public interface CarService {
    public Car addCar(Car car);
    public CarResponse getCarById(Integer id);
    public CarResponse updateCar(Integer id, CarRequest carRequest);
    public CarResponse deleteById(Integer id);
}
