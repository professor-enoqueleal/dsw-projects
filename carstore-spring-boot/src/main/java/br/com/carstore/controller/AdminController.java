package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "admin/index";

    }

    @GetMapping("/admin/index")
    public String indexTwo(Model model) {

        model.addAttribute("carDTO", new CarDTO());

        return "admin/index";

    }

    @PostMapping("/admin/cars")
    public String createCar(@ModelAttribute CarDTO car, Model model) {

        if (car.getId() != null && !car.getId().isBlank()) {

            carService.update(car.getId(), car);

        } else {

            carService.save(car);

        }

        return "redirect:/admin/cars";

    }

    @GetMapping("/admin/cars")
    public String getAllCars(Model model) {

        List<CarDTO> cars = carService.findAll();

        model.addAttribute("cars", cars);

        return "admin/dashboard";

    }

    @GetMapping("/admin/cars/edit")
    public String editCar(@RequestParam("id") String id, Model model) {

        CarDTO car = carService.findById(id);

        if (car == null) {

            return "redirect:/admin/cars";

        }
        model.addAttribute("carDTO", car);

        return "admin/index";

    }

    @PostMapping("/admin/cars/delete")
    public String deleteCar(@RequestParam("id") String id, Model model) {

        carService.deleteById(id);

        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);

        return "redirect:/admin/cars";

    }

}
