package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private CarService carService;
	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/car")
	public String getCar(ModelMap model, @RequestParam(required = false) int repeat, @RequestParam int count) {
		List<String> price = new ArrayList<>();
		for (int i = 0; i <= repeat; i++) {
			price.add("BMV,  price = " + i * 1000);
		}

		model.addAttribute("car", "bmv");
		model.addAttribute("price", price);
		return "car";
	}

	@GetMapping(value = "/cars")
	public String getCars(ModelMap model, @RequestParam(defaultValue = "5") int count) {
		model.addAttribute("cars", carService.getCars(count));
		return "cars";
	}


	
}