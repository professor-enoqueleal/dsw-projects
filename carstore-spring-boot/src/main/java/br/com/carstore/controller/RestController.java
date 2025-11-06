package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.model.CarResponseEntity;
import br.com.carstore.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private CarService carService;

    public RestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<CarResponseEntity> home() {

        List<CarDTO> cars = carService.findAll();

        CarResponseEntity carResponseEntity = new CarResponseEntity(cars);

        return ResponseEntity.ok(carResponseEntity);

    }

    @PostMapping("/api/cars")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO car) {

        carService.save(car);

        return ResponseEntity.ok(car);

    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/api/cars/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable("id") String id, @RequestBody CarDTO carDTO) {

        try {

            CarDTO existing = carService.findById(id);

            if (existing == null) {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception ex) {

            return ResponseEntity.notFound().build();

        }

        carService.update(id, carDTO);

        return ResponseEntity.noContent().build(); // 204 No Content

    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") String id) {
        try {
            CarDTO existing = carService.findById(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }

        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
