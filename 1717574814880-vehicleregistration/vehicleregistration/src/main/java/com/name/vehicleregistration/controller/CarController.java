package com.name.vehicleregistration.controller;

import com.name.vehicleregistration.controller.mappers.CarMapper;
import com.name.vehicleregistration.controller.dtos.CarRequest;
import com.name.vehicleregistration.controller.dtos.CarResponse;
import com.name.vehicleregistration.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CarMapper carMapper;

    @Operation(summary = "Llamada para añadir vehículos")
    @PostMapping("/")
    public ResponseEntity<?> addCar(@RequestBody CarRequest carRequest){
        try {
            CarResponse carResponse = carService.addCar(carRequest);
            log.info("Coche añadido correctamente");
            return ResponseEntity.ok(carResponse);
        } catch (Exception e) {
            log.error("POST - Error en el servidor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }


    @Operation (summary = "Llamada para obtener coche por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) {
        try {
            CarResponse carResponse = carService.getCarById(id);
            log.info("Coche hallado correctamente");
            return ResponseEntity.ok(carResponse);
        } catch (NoSuchElementException e) {
            log.warn("GET - {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coche no encontrado");
        } catch (Exception e) {
            log.error("GET - Error en el servidor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }


    @Operation (summary = "Llamada para actualizar coche por id")
    @PutMapping("/{id}")
    public ResponseEntity<?> putCar (@PathVariable Integer id, @RequestBody CarRequest carRequest){
        try {
            CarResponse carResponse = carService.updateCar(id, carRequest);
            log.info("Coche actualizado correctamente");
            return ResponseEntity.ok(carResponse);
        }
        catch (Exception e){
            log.error("PUT - {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coche no encontrado");
        }
    }

    @Operation (summary = "Llamada para eliminar coche por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar (@PathVariable Integer id){
        try {
            CarResponse car = carService.deleteById(id);
            log.info("Coche eliminado correctamente");
            return ResponseEntity.ok(car);
        } catch (NoSuchElementException e) {
            log.warn("DELETE - {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coche no encontrado");
        } catch (Exception e) {
            log.error("DELETE - Error en el servidor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }
}
