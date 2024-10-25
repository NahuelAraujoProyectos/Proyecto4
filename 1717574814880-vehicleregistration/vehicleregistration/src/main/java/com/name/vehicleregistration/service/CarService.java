package com.name.vehicleregistration.service;

import com.name.vehicleregistration.controller.dtos.CarRequest;
import com.name.vehicleregistration.controller.dtos.CarResponse;


public interface CarService {
    public CarResponse addCar(CarRequest carRequest);
    public CarResponse getCarById(Integer id);
    public CarResponse updateCar(Integer id, CarRequest carRequest);
    public CarResponse deleteById(Integer id);
}
