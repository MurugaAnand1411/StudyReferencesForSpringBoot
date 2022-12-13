package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Shoes;

public interface shoesRep  extends JpaRepository<Shoes, Long> {
	
}
