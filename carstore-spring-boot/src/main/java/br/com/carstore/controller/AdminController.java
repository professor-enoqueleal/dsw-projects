package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    private CarService carService;

    public AdminController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/admin")
    public String index(Model model) {

        model.addAttribute("carDTO", new CarDTO());

        return "index";

    }

    @GetMapping("/admin/index")
    public String indexTwo(Model model) {

        model.addAttribute("carDTO", new CarDTO());

        return "index";

    }

    @PostMapping("/admin/cars")
    public String createCar(@ModelAttribute CarDTO car, Model model) {

        carService.save(car);

        List<CarDTO> cars = carService.findAll();

        model.addAttribute("cars", cars);

        return "dashboard";

    }

    @GetMapping("/admin/cars")
    public String getAllCars(Model model) {

        List<CarDTO> cars = carService.findAll();

        model.addAttribute("cars", cars);

        return "dashboard";

    }


}
