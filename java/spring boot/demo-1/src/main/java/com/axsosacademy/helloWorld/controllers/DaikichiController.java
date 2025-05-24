package com.axsosacademy.helloWorld.controllers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/daikichi")
public class DaikichiController {
	   public static void main(String[] args) {
		   SpringApplication.run(DaikichiController.class, args);
		   
	   }
	   @RequestMapping("")
       public String index() { 
               return "Welcome!";
	   }
	   
	   @RequestMapping("/today")
       public String index2() { 
               return "Today you will find luck in all your endeavors!";
	   }
	   
	   @RequestMapping("/tomorrow")
       public String index3() { 
               return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	   }
	    
	   
}
