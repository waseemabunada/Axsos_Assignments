package com.example.axsos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.axsos.models.Student;
import com.example.axsos.services.DormService;
import com.example.axsos.services.StudentService;

import jakarta.validation.Valid;
@Controller

public class Studentcontrollers {
@Autowired 
private StudentService studentServices;
@Autowired 
private DormService dormServices;


	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute ("student") Student student,Model model) {
		model.addAttribute("dorms",dormServices.findAllDorms());
		return "newStudent";
	}
	@PostMapping("/students/form")
	public String createStudent(@Valid @ModelAttribute ("student") Student student ,BindingResult result) {
		if (result.hasErrors()) {
			return "newStudent";
		}
		studentServices.createStudent(student);
		 if (student.getDorm() != null) {
		        return "redirect:/dorm/"+student.getDorm().getId();
		    } else {
		        return "redirect:/dorms"; 
		    }
        }
	@DeleteMapping("/destroy/{id}")
	public String destroy(@PathVariable("id") Long id) {
	    Student student = studentServices.findStudent(id);
	    Long dormId = student.getDorm().getId(); 
	    studentServices.deleteStudent(id); 
	    return "redirect:/dorm/" + dormId; 
	}

}