package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicController {

    private final CarService carService;

    public PublicController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("carDTO", new CarDTO());

        return "redirect:/cars";

    }

    @GetMapping("/home")
    public String indexTwo(Model model) {

        model.addAttribute("carDTO", new CarDTO());

        return "redirect:/cars";

    }

    @GetMapping("/detail")
    public String getDetail(Model model, @RequestParam String id) {

        CarDTO carDTO = carService.findById(id);

        // Adiciona o DTO obtido ao model para que o template possa mostrar os valores
        model.addAttribute("car", carDTO);

        return "public/detail";

    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {

        List<CarDTO> cars = carService.findAll();

        model.addAttribute("cars", cars);

        return "public/home";

    }

}
