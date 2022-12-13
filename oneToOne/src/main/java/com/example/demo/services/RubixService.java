package com.example.demo.services;



import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RubixDto;
import com.example.demo.models.Rubix;
import com.example.demo.repo.RubixRepository;
@Service

public class RubixService {
	
	@Autowired
	private RubixRepository rubixRepository;
	
public ResponseEntity<RubixDto> saveData(Rubix rubic){
	rubixRepository.save( rubic);
	RubixDto rubixDto= new RubixDto();
	BeanUtils.copyProperties(rubic, rubixDto);
	return ResponseEntity.ok(rubixDto);
	
}
	

public List<Rubix> getAllData(){
return rubixRepository.findAll();
}

}
