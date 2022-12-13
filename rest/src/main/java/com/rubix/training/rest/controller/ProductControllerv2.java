package com.rubix.training.rest.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/rubixshop-v2")
/**
 * FOLLOW BEST PRACTISES FOR REST CONTROLLERS
 * @author Rubx-HP
 *
 */
public class ProductControllerv2 {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value="/products")
	public ResponseEntity<Collection<Product>> getAllProducts() {
		System.out.println("Going to get all products");
		Collection<Product> products =  service.getAllProducts();
		return ResponseEntity.ok().body(products);
	}
	
	@PostMapping(value="/products")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		Product p = service.addProduct(product);
		URI uri = URI.create("/rubixshop-v2/products/" + p.getId());
		return ResponseEntity.created(uri).body(p);
	}
	
	@PutMapping(value="/products/{id}")
	public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody Product product) {
		
		Product p = service.getProductById(id);
	
		if (p != null) {
			service.updateProduct(product);
			return ResponseEntity.ok().build();
		} else  return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> removeProduct(@PathVariable long id) {
		
		Product p = service.getProductById(id);
		
		if (p != null) {
			service.removeProduct(id);
			return ResponseEntity.ok().build();
		} else  return ResponseEntity.notFound().build();
		
	}

	//-- http://localhost:8080/rubixshop/products
}
