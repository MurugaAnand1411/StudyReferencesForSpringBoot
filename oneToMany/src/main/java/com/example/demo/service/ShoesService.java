package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Shoes;
import com.example.demo.repo.shoesRep;

@Service
public class ShoesService {
	
	@Autowired
	private shoesRep shoesrep;
	
	public Optional<Shoes> createsSho(Shoes sho){
		return Optional.of(shoesrep.save(sho));
	}
	
	public List<Shoes> getAllshoes(){
		return shoesrep.findAll();
	}	
	
	public Optional<Shoes> getOneShoe(Long id){
		return shoesrep.findById(id);
	}
	
	public Optional<Shoes> updateShoes(Shoes sho){
		return Optional.of(shoesrep.save(sho));
	}
	
	public String delete(Long shoeId) {
		if (shoesrep.existsById(shoeId)) {
			shoesrep.deleteById(shoeId);
			return shoeId + " deleted successfully!";
		} else {
			return "The shoes data does not exist in records!";
		}

	}

}
