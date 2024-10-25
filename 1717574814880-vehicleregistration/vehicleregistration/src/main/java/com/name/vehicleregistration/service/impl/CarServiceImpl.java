package com.name.vehicleregistration.service.impl;

import com.name.vehicleregistration.controller.dtos.CarRequest;
import com.name.vehicleregistration.controller.dtos.CarResponse;
import com.name.vehicleregistration.controller.mappers.CarMapper;
import com.name.vehicleregistration.entity.CarEntity;
import com.name.vehicleregistration.repository.CarRepository;
import com.name.vehicleregistration.service.CarService;
import com.name.vehicleregistration.service.converters.CarConverter;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Transactional
    public CarResponse addCar(CarRequest carRequest){
        CarEntity carEntity = carRepository.save(carConverter.toEntity(carMapper.toModel(carRequest)));
        return carMapper.toResponse(carConverter.toModel(carEntity));
    }

    @Transactional
    public CarResponse getCarById(Integer id) {
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            CarEntity carEntity = carOptional.get();
            return carMapper.toResponse(carConverter.toModel(carEntity));
        }
        return null;
    }

    @Transactional
    public CarResponse updateCar(Integer id, CarRequest carRequest){
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
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
        return  null;
    }

    @Transactional
    public CarResponse deleteById(Integer id){
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            CarEntity carEntityDeleted = carOptional.get();
            carRepository.deleteById(id);
            return carMapper.toResponse(carConverter.toModel(carEntityDeleted));
        }
        return null;
    }
}
