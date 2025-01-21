package com.example.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@RequestMapping("/")
	public String greet(){	
		
		return "hello man";
		}
	
	
	
	
	

}
