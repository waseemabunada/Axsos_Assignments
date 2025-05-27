package com.example.axsos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Omikuji")
public class Omikuji {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/display")
	public String index(
	    @RequestParam(value="number") String number,
	    @RequestParam(value="name_city") String name_city,
	    @RequestParam(value="name_person") String name_person,
	    @RequestParam(value="professional") String professional,
	    @RequestParam(value="nice") String nice, HttpSession session) {

		session.setAttribute("number", number);
		session.setAttribute("name_city", name_city);
		session.setAttribute("name_person", name_person);
		session.setAttribute("professional", professional);
		session.setAttribute("nice", nice);
		
		return "redirect:/Omikuji/show";
	}
	@RequestMapping("/show")
	public String show() {
		return "show";
	}
	
}


