package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Dancer;

import com.example.demo.repo.DancerRepo;

@Service
public class DancerService {

		@Autowired
		private DancerRepo dancerRepo;
		
		public Optional<Dancer> createsDancer(Dancer dan){
			return Optional.of(dancerRepo.save(dan));
		}
		
		public List<Dancer> getAllDancer(){
			return dancerRepo.findAll();
		}	
		
		public Optional<Dancer> getOneDancer(Long id){
			return dancerRepo.findById(id);
		}
		
		public Optional<Dancer> updateDancerDetails(Dancer danc){
			return Optional.of(dancerRepo.save(danc));
		}
		
		public String delete(Long dancerId) {
			if (dancerRepo.existsById(dancerId)) {
				dancerRepo.deleteById(dancerId);
				return dancerId + " deleted successfully!";
			} else {
				return "The shoes data does not exist in records!";
			}


		}
}


