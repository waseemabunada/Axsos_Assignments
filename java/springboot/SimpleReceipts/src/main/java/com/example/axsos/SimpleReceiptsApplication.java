package com.example.axsos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller

public class SimpleReceiptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleReceiptsApplication.class, args);
	}

}
