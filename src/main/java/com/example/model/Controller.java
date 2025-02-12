package com.example.model;

import java.io.IOException;
//import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

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
	
	@PostMapping("product")
	public ResponseEntity<?> addProduct(@RequestPart Products product,@RequestPart MultipartFile imageFile){
		try {
		Products product1=service.addProduct(product,imageFile);
		return new ResponseEntity<>(product1,HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}	
	
//	 @GetMapping("/product/{productId}/image")
//	 public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
//		 
//		 Products product=service.getProductById(productId);
//		 
//		 byte[] imageFile=product.getImageDate();
////		 String imageType = product.getImageType();
////		 MediaType mediaType = MediaType.valueOf(imageType); 
//		 
//		 return ResponseEntity.ok()
//				 .contentType(org.springframework.http.MediaType.)
//				 .body(imageFile);
//		 
//	//	 .contentType(MediaType.valueOf(product.getImageType()))
//		 
//	 }
	    @GetMapping("/product/{productId}/image")
	    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
	        Products product = service.getProductById(productId);
	        byte[] imageFile = product.getImageDate();

	        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);

	    }
	    
	    
	    @PutMapping("/product/{id}")
	    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Products product, @RequestPart MultipartFile imageFile) {

	        Products product1 = null;
	        try {
	            product1 = service.updateProduct(id, product, imageFile);
	        } catch (IOException e) {
	            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
	        }
	        if (product1 != null) {
	            return new ResponseEntity<>("updated", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
	        }


	    }


	    @DeleteMapping("/product/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
	        Products product = service.getProductById(id);
	        if (product != null) {
	            service.deleteProduct(id);
	            return new ResponseEntity<>("Deleted", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	        }

	    }
	    
	    

}
