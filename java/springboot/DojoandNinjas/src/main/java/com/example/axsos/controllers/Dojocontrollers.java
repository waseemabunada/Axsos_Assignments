package com.example.axsos.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.axsos.models.Dojo;
import com.example.axsos.services.DojoService;

import jakarta.validation.Valid;
 
@Controller
 
public class Dojocontrollers {
    @Autowired
    private DojoService dojoService;
    @GetMapping("/")
    public String newDojo(@ModelAttribute ("dojos") Dojo dojo) {  
    	System.out.println("batata");//@ModelAttribute ("نفس اللي بكون بالفورم")
    	return "dojo";
    }
    @PostMapping("/dojo/form")
    public String createDojo(@Valid @ModelAttribute ("dojos") Dojo dojo, BindingResult result) {
    	  if (result.hasErrors()) {
              return "dojo";
          }
		dojoService.createDojo(dojo);
          return "redirect:/new/ninjas";
    }
    @GetMapping("/display/{id}")
    public String dsplayDojo(@PathVariable("id") Long id ,Model model) {
    	model.addAttribute("dojo",dojoService.findDojo(id));
    	return "display"; 
    }
}