package com.example.demo;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface ProductRepos extends CrudRepository<ProductModel,Long> {
	//List<Employee> findByRegion(String region);
	//List<ProductModel>findByAssuranceCheck(String assuranceCheck);

//	
	
	//List<ProductModel> findByPriceAndProductName(double i, String productname);

	List<ProductModel> findByPriceAndProductname(int i, String productname);
	
	//List<ProductModel> findByAssuranceCheckOrPriceGreaterThanOrEqualTo(String assuranceCheck , double price);
	
	//@Query("select p from ProductModel  p where p.price >= ?1 and p.price <= ?2")
	// List<ProductModel> findInPriceRange(double from, double to);
	
	//Page<ProductModel> findByPriceGreaterThan(double price, Pageable pageable);
	

}
