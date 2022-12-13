package com.rubix.training.rest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.training.rest.domain.Product;
import com.rubix.training.rest.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(String name, double price) {
		Product product = new Product(name, price);
		repository.insert(product);
		return product;
	}
	
	
	public Product addProduct(Product prod) {
		repository.insert(prod);
		return prod;
	}
	
	public Collection<Product> getAllProducts() {
		return repository.getAll();
	}
	
	public Product getProductById(long id) {
		Product p = repository.getById(id);
		return p;
	}
	
	public String updateProduct(Product p) {
		boolean success = repository.update(p);
		if (success)  {
			return "Product updated";
		} else {
			return "Sorry cannot update";
		}
	}
	
	public String removeProduct(long pId) {
		boolean success = repository.delete(pId);
		if (success)  {
			return "Product deleted";
		} else {
			return "Sorry cannot delete non-existent product";
		}
	}

}
