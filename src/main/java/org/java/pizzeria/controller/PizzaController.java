package org.java.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/pizzas")
	public String goToPizzaIndex(Model model) {
		
		List<Pizza> pizzaList = pizzaService.findAll();
		
		model.addAttribute("pizzaList", pizzaList);
		
		return "index";
	}
	
	@PostMapping("/pizzas")
	public String goToPizzaIndexResearch(Model model, @RequestParam(required = false) String name) {
		
		List<Pizza> pizzaList = pizzaService.findByNameContaining(name);
		
		model.addAttribute("pizzaList", pizzaList);
		model.addAttribute("searchTerm", name);
		
		return "index";
	}
	
	@GetMapping("/pizzas/{id}")
	public String goToPizzaDetails(Model model, @PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "details";
	}
	
}
