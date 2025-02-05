package com.example.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private ProductService service;
	
	
	@RequestMapping("/")
	public String greet(){	
		
		return "hello man";
		}
	
	
//	@GetMapping("/products")
//	public List<Products> getAllProducts(){
//		
//		
//		return service.getAllProducts();
//		
//		
//	}
	
	//yukaridakinin yerine asagidakini ekledim
	
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAllProducts(){
		
		
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
		
		
	}
	
//	@GetMapping("/product/{id}")
//	public Products getproduct(@PathVariable int id) {
//		
//		
//		return service.getProductById(id);
//		
//		
//		
//	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Products> getproduct(@PathVariable int id) {
		Products products =service.getProductById(id);
		
		if(products != null)
		return new ResponseEntity<>(products,HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	
	

}
