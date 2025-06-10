package com.example.axsos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.axsos.models.Ninja;
import com.example.axsos.services.DojoService;
import com.example.axsos.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class Ninjacontrollers {
	@Autowired
   private NinjaService ninjaService;
	@Autowired
   private DojoService dojoService;

	@GetMapping("/new/ninjas")
   public String newNinja(@ModelAttribute ("ninjas") Ninja ninja,Model model) {
		model.addAttribute("dojos",dojoService.findAllDojos() );
   	return "ninja";
   }
	@PostMapping("/ninja/form")
   public String createNinja(@Valid @ModelAttribute ("ninjas") Ninja ninja, BindingResult result) {
   	  if (result.hasErrors()) {
             return "ninja";
         }
   	  ninjaService.createNinja(ninja);
         return "redirect:/display/" + ninja.getDojo().getId();
   }
}