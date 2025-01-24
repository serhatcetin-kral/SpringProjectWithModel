package com.example.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private ProductService service;
	
	
	@RequestMapping("/")
	public String greet(){	
		
		return "hello man";
		}
	
	
	@GetMapping("/products")
	public List<Products> getAllProducts(){
		
		
		return service.getAllProducts();
		
		
	}
	
	
	

}
