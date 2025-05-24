package com.example.axsos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Human {

		public static void main(String[] args) {
			SpringApplication.run(Human.class, args);
		}

	 @RequestMapping("/")
     public String hello() {
             return "Hello Human";
     }
	 
	 @RequestMapping("test/")
	 public String index(@RequestParam(value="name") String name , @RequestParam(value="l_name") String l_name ) {
	        return "Hello" + " " + name + l_name;
	    }
	 
	 
	 @RequestMapping("test2/")
	 public String index2(
	     @RequestParam(value = "name") String name,
	     @RequestParam(value = "l_name") String l_name,
	     @RequestParam(value = "times") int times
	 ) {
	     String greeting = "Hello " + name + " " + l_name + " " ;
	     return greeting.repeat(times);
	 }

	 
	 
	 
}
