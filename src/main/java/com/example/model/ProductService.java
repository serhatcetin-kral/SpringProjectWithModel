package com.example.model;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepo repo;
	
	
	
	
	public List<Products> getAllProducts() {
		
		return repo.findAll();
	}




//	public Products getProductById(int id) {
//		
//		return repo.findById(id).get();
//	}
	
	
public Products getProductById(int id) {
		
		return repo.findById(id).orElse(null);
	}




public Products addProduct(Products product, MultipartFile imageFile) throws IOException {
	// TODO Auto-generated method stub
	
	
	product.setImageName(imageFile.getOriginalFilename());
	product.setImageType(imageFile.getContentType());
	product.setImageDate(imageFile.getBytes());
	return repo.save(product);
}
	

}
