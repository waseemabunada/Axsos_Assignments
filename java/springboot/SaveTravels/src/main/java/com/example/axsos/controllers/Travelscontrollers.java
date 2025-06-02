package com.example.axsos.controllers;
import com.example.axsos.services.TravelsService;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.axsos.models.Travels;
import com.example.axsos.services.TravelsService;

import jakarta.validation.Valid;

@Controller

public class Travelscontrollers {
	
	private final  TravelsService  travelsService;

	public Travelscontrollers(TravelsService travelsService) {
		this.travelsService = travelsService;

}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("travels", new Travels());
		model.addAttribute("travelss", travelsService.allTravels());
		return "index";
	}
	
	@PostMapping("/")
	public String create(@Valid @ModelAttribute("travels") Travels travels, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("travelss", travelsService.allTravels());
			return "index";
		}
		travelsService.createTravels(travels);
		return "redirect:/";
	} 
	
	@GetMapping("/expenses/edit/{id}")
	public String desplay(@PathVariable Long id, Model model) {
	    Travels travels1 = travelsService.findTravels(id);
	    model.addAttribute("travels", travels1);
	    return "edit";
	}

	
	
	@PutMapping("/expenses/edit/{id}")
	 public String edit(
	     @Valid @ModelAttribute("travels") Travels travels,
	     BindingResult result,
	     @PathVariable("id") Long id,
	     Model model
	 ) {
	     if (result.hasErrors()) {
	         return "edit"; 
	     }

	     travels.setId(id);
	     travelsService.updateTravels(travels);
	     return "redirect:/";
	 }
	
	
	@GetMapping("/expenses/{id}")
	public String displayExpense(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("travels", travelsService.findTravels(id));
	    System.out.println(model.getAttribute("travels"));
	    return "display";
	}

	
	@RequestMapping(value="/travels/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
	    travelsService.deletetravel(id);
	    return "redirect:/";
	}

	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

