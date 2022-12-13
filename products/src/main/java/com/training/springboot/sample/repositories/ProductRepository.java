package com.training.springboot.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.sample.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}