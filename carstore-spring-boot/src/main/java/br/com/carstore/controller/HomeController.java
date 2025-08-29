package br.com.carstore.controller;

import br.com.carstore.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @PostMapping("/create-car")
    public ResponseEntity<Car> createCar(@ModelAttribute Car car) {

        System.out.printf("Car name: " + car.getName());
        System.out.println("Car color: " + car.getColor());

        return ResponseEntity.ok(car);

    }

}
