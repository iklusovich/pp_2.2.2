package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarService;



@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")

    public String getCars( @RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        if (count > 5) {
            count = 5;
        }
        model.addAttribute("cars", carService.getCars().stream().limit(count).toList());
        model.addAttribute("title", "Cars list");
        return "cars";
    }

}
