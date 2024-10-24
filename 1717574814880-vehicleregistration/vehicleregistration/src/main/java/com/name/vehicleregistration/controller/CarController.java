package com.name.vehicleregistration.controller;

import com.name.vehicleregistration.controller.mappers.CarMapper;
import com.name.vehicleregistration.model.dtos.CarRequest;
import com.name.vehicleregistration.model.dtos.CarResponse;
import com.name.vehicleregistration.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            CarResponse carResponse = carMapper.toResponse(carService.addCar(carMapper.toModel(carRequest)));
            log.info("Coche añadido correctamente");
            return ResponseEntity.ok(carResponse);
        } catch (Exception e) {
            log.error("POST - Error en el servidor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }


    @Operation (summary = "Llamada para obtener coche por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) {
        try {
            CarResponse carResponse = carMapper.toResponse(carService.getCarById(id));
            log.info("Coche hallado correctamente");
            return ResponseEntity.ok(carResponse);
        }catch (Exception e){
            log.error("GET - Elemento no encontrado: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


    @Operation (summary = "Llamada para actualizar coche por id")
    @PutMapping("/{id}")
    public ResponseEntity<?> putCar (@PathVariable Integer id, @RequestBody CarRequest carRequest){
        try {
            CarResponse carResponse = carMapper.toResponse(carService.updateCar(id, carMapper.toModel(carRequest)));
            log.info("Coche actualizado correctamente");
            return ResponseEntity.ok(carResponse);
        }
        catch (Exception e){
            log.error("PUT - Elemento no encontrado: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @Operation (summary = "Llamada para eliminar coche por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar (@PathVariable Integer id){
        try {
            CarResponse carResponse = carMapper.toResponse(carService.deleteById(id));
            log.info("Coche eliminado correctamente");
            return ResponseEntity.ok(carResponse);
        } catch (Exception e){
            log.error("DELETE - Elemento no encontrado: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
