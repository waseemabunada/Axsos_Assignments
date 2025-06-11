package com.example.axsos.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.axsos.models.LoginUser;
import com.example.axsos.models.User;
import com.example.axsos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	final private UserService userSerivce;
	
	public HomeController(UserService userService) {
		this.userSerivce = userService;
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("userLogin") LoginUser userLogin, @ModelAttribute("userSignup") User user ,HttpSession session) {
		if(session.getAttribute("loggedUser") != null) {
			return "redirect:/home";
		}
	     model.addAttribute("userLogin", new LoginUser());
	     model.addAttribute("userSignup", new User() );
	     return "index";
	}

	
	@PostMapping("/userlogin")
	public String login(@Valid @ModelAttribute("userLogin") LoginUser userLogin ,BindingResult result,HttpSession session ,Model model) {
		User userlogged = userSerivce.Login(userLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("userSignup", new User());
    		return "index";
		}
		else {
			session.setAttribute("loggedUser", userlogged);
    		return "redirect:/home";
		}
	}
	
	
	@PostMapping("/usersignup")
	public String signUp(@Valid @ModelAttribute("userSignup") User user, BindingResult result, HttpSession session , Model model) {
		User signedUpUser = userSerivce.register( user , result);
		if ( result.hasErrors()) {
			model.addAttribute("userLogin", new LoginUser());
			return "index";
		}else {
    		session.setAttribute("loggedUser", signedUpUser);
    		return "redirect:/home";
    	}	
	}
	
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }

}
