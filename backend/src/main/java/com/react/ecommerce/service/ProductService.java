package com.react.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.ecommerce.domain.Category;
import com.react.ecommerce.domain.Product;
import com.react.ecommerce.repository.CategoryRepository;
import com.react.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public String addCategory(Category category) {
		categoryRepository.save(category);
		return "Category saved";
	}
	
	public String addProduct(long categoryId,Product product) {
		Category category=categoryRepository.findByCategoryId(categoryId);
		Product products = new Product();
	    BeanUtils.copyProperties(product, products,"category");
	    products.setCategory(category);
	    productRepository.save(products);
	    return "product saved";
	}
	public Optional<Product> getProductDetails(long productId) {
		return productRepository.findById(productId);
	}
	public List<Product> getProductListByName(String productName) {
		return productRepository.findDataByProductNameLetter(productName);
	}

}
