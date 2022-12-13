package com.training.springboot.sample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.sample.entities.Sale;
import com.training.springboot.sample.entities.User;

public interface SalesRepository extends JpaRepository<Sale, Long> {
	
	public List<Sale> getSaleByUser(User user);

}


