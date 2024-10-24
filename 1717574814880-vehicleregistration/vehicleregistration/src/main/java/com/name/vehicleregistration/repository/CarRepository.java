package com.name.vehicleregistration.repository;

import com.name.vehicleregistration.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
