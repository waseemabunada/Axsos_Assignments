package com.example.axsos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariables {
	
	  @RequestMapping("/daikichi/travel/{city}")
	    public String travel(@PathVariable("city") String city) {
	        return "Congratulations! You will soon travel to " + city + "!";

              }
	  
	  
	  @RequestMapping("/daikichi/lotto/{id}")
	    public String lotto(@PathVariable("id") int id) {
		  if (id % 2 == 0) {
	            return "You will take a grand journey in the near future but be wary of tempting offers.";
	        } else {
	            return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
	        }
	    }
	  
}