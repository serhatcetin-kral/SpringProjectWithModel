package com.example.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepo repo;
	
	
	
	
	public List<Products> getAllProducts() {
		
		return repo.findAll();
	}
	
	
	
	

}
