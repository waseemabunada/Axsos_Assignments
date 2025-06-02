package com.example.axsos.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.axsos.models.Burger;
import com.example.axsos.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {	

	private final BurgerService burgerService;

	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("burger", new Burger());
		model.addAttribute("burgers", burgerService.allBurgers());
		return "index";
	}

	@PostMapping("/")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers());
			return "index";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	} 
	
	
	@GetMapping("/burgers/edit/{id}")
    public String desplay(@PathVariable Long id,@ModelAttribute("burger") Burger burger,Model model) {
 		Burger burger1 =burgerService.findBurger(id);
 		model.addAttribute("burger", burger1);
		return "edit";
	}
	
	
	@PutMapping("/burgers/edit/{id}")
	 public String edit(
	     @Valid @ModelAttribute("burger") Burger burger,
	     BindingResult result,
	     @PathVariable("id") Long id,
	     Model model
	 ) {
	     if (result.hasErrors()) {
	         return "edit"; 
	     }

	     burger.setId(id);
	     burgerService.updateBurger(burger);
	     return "redirect:/";
	 }
}