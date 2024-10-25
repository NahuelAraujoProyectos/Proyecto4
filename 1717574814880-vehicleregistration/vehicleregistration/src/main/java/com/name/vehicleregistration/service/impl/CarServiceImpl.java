package com.name.vehicleregistration.service.impl;

import com.name.vehicleregistration.controller.dtos.CarRequest;
import com.name.vehicleregistration.controller.dtos.CarResponse;
import com.name.vehicleregistration.controller.mappers.CarMapper;
import com.name.vehicleregistration.entity.CarEntity;
import com.name.vehicleregistration.repository.CarRepository;
import com.name.vehicleregistration.service.CarService;
import com.name.vehicleregistration.service.converters.CarConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarConverter carConverter;

    public CarResponse addCar(CarRequest carRequest){
        CarEntity carEntity = carRepository.save(carConverter.toEntity(carMapper.toModel(carRequest)));
        return carMapper.toResponse(carConverter.toModel(carEntity));
    }


    public CarResponse getCarById(Integer id) {
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if(carOptional.isEmpty()){
            throw new NoSuchElementException("Coche con ID " + id + " no encontrado.");
        }
        CarEntity carEntity = carOptional.get();
        return carMapper.toResponse(carConverter.toModel(carEntity));
    }


    public CarResponse updateCar(Integer id, CarRequest carRequest){
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if(carOptional.isEmpty()){
            throw new NoSuchElementException("Coche con ID " + id + " no encontrado.");
        }
        CarEntity carEntityUpdate = carOptional.get();
        carEntityUpdate.setBrand(carRequest.getBrand());
        carEntityUpdate.setModel(carRequest.getModel());
        carEntityUpdate.setMilleage(carRequest.getMilleage());
        carEntityUpdate.setPrice(carRequest.getPrice());
        carEntityUpdate.setModelYear(carRequest.getModelYear());
        carEntityUpdate.setDescription(carRequest.getDescription());
        carEntityUpdate.setColour(carRequest.getColour());
        carEntityUpdate.setFuelType(carRequest.getFuelType());
        carEntityUpdate.setNumDoors(carRequest.getNumDoors());
        carRepository.save(carEntityUpdate);
        return carMapper.toResponse(carConverter.toModel(carEntityUpdate));
    }


    public CarResponse deleteById(Integer id){
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new NoSuchElementException("Coche con ID " + id + " no encontrado.");
        }
        CarEntity carEntityDeleted = carOptional.get();
        carRepository.deleteById(id);
        return carMapper.toResponse(carConverter.toModel(carEntityDeleted));
    }
}
