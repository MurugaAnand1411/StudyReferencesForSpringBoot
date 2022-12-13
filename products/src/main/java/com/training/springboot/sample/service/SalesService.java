package com.training.springboot.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.springboot.sample.entities.Sale;
import com.training.springboot.sample.entities.User;
import com.training.springboot.sample.repositories.SalesRepository;

@Service
@Transactional
public class SalesService {
	
	@Autowired
	private SalesRepository repo;
	
	public List<Sale> listAll() {
		return repo.findAll();
	}
	
	public void save(Sale sales) {
		repo.save(sales);
	}
	
	public Sale get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public List<Sale> getOrdersForUser(User user) {
		return  repo.getSaleByUser(user);
	}
}


