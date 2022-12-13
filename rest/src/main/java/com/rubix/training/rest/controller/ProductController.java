package com.rubix.training.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.training.rest.domain.Product;
import com.rubix.training.rest.service.ProductService;


@RestController
@RequestMapping("/rubixshop")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value="/products")
	public Collection<Product> getAllProducts() {
		System.out.println("Going to get all products");
		return service.getAllProducts();
	}
	
	@PostMapping(value="/products")
	public Product insertProduct(@RequestBody Product product) {
		Product p = service.addProduct(product);
		return p;
	}
	
	@PutMapping(value="/products/{id}")
	public String updateProduct(@PathVariable long id, @RequestBody Product product) {
		
		Product p = service.getProductById(id);
	
		if (p != null) {
			String msg = service.updateProduct(product);
			return msg;
		} else return "Cannot update non-existent product";
	}
	
	
	@DeleteMapping("/products/{id}")
	public String removeProduct(@PathVariable long id) {
		
		Product p = service.getProductById(id);
		
		if (p != null) {
			String msg = service.removeProduct(id);
			return msg;
		} else return "Cannot update non-existent product";
		
	}

	//-- http://localhost:8080/rubixshop/products
}
