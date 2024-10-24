package com.name.vehicleregistration.service.impl;

import com.name.vehicleregistration.model.CarModel;
import com.name.vehicleregistration.model.entity.Car;
import com.name.vehicleregistration.repository.CarRepository;
import com.name.vehicleregistration.service.CarService;
import com.name.vehicleregistration.service.converters.CarConverter;
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
    private CarConverter carConverter;

    public  CarModel addCar(CarModel carModel){
        Car car = carRepository.save(carConverter.toEntity(carModel));
        return carConverter.toModel(car);
    }

    public CarModel getCarById(Integer id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            Car car = carOptional.get();
            return carConverter.toModel(car);
        }
        return null;
    }

    public CarModel updateCar(Integer id,CarModel carModel){
        Optional<Car> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            Car carUpdate = carOptional.get();
            carUpdate.setBrand(carModel.getBrand());
            carUpdate.setModel(carModel.getModel());
            carUpdate.setMilleage(carModel.getMilleage());
            carUpdate.setPrice(carModel.getPrice());
            carUpdate.setModel_year(carModel.getModel_year());
            carUpdate.setDescription(carModel.getDescription());
            carUpdate.setColour(carModel.getColour());
            carUpdate.setFuelType(carModel.getFuelType());
            carUpdate.setNumDoors(carModel.getNumDoors());
            carRepository.save(carUpdate);
            return carConverter.toModel(carUpdate);
        }
        return  null;
    }

    public CarModel deleteById(Integer id){
        Optional<Car> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            Car carDeleted = carOptional.get();
            carRepository.deleteById(id);
            return carConverter.toModel(carDeleted);
        }
        return null;
    }
}
