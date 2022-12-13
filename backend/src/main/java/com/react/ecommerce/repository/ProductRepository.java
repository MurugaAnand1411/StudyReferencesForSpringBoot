package com.react.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.react.ecommerce.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	List<Product> findByProductNameIgnoreCase(String productName);
	@Query(value = "SELECT * from product  WHERE LOWER(product_name)  LIKE :productName ||'%'", nativeQuery = true)
	List<Product> findDataByProductNameLetter(@Param("productName") String productName);
	
}
