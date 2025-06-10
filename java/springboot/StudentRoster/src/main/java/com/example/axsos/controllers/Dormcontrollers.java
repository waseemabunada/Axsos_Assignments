package com.example.axsos.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.axsos.models.Dorm;
import com.example.axsos.models.Student;
import com.example.axsos.services.DormService;
import com.example.axsos.services.StudentService;

import jakarta.validation.Valid;
 
@Controller
 
public class Dormcontrollers {
    @Autowired
    private DormService dormService;
    
	@Autowired 
	private StudentService studentServices;
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute ("dorm") Dorm dorm) {
		return "newdorm";
	}
	
	@PostMapping("/dorms/form")
	public String createDorm(@Valid @ModelAttribute ("dorm") Dorm dorm ,BindingResult result) {
		if (result.hasErrors()) {
			return "newDorm";
		}
		dormService.createDorm(dorm);
        return "redirect:/students/new";
        }
	@GetMapping("/dorms")
	public String dorms(Model model) {
		model.addAttribute("dorms",dormService.findAllDorms());
		model.addAttribute("student",studentServices.findAllStudent());
		return "dorms";
	}
	
	@GetMapping("/dorm/{id}")
	public String dormDetails(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("dorm", dormService.findDorm(id));
	    model.addAttribute("students", studentServices.findAllUnassigned());
	    model.addAttribute("student", new Student());
	    return "dormDetails";
	}
	
	@PostMapping("/dorm/{dormId}/assign")
	public String assignStudentToDorm(
	        @PathVariable("dormId") Long dormId,
	        @RequestParam("studentId") Long studentId) {

	    Student existingStudent = studentServices.findStudent(studentId);
	    Dorm dorm = dormService.findDorm(dormId);

	    existingStudent.setDorm(dorm);
	    studentServices.createStudent(existingStudent);

	    return "redirect:/dorm/" + dormId;
	}

}