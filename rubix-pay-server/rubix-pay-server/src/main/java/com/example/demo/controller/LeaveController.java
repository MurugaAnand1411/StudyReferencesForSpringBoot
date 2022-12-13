package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LeaveEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.LeaveService;

@CrossOrigin
@RestController
public class LeaveController {
	
	@Autowired
	LeaveService leaveService;
	
	@GetMapping("/leaves")
	public List<LeaveEntity> getEmployee()
	{
		List<LeaveEntity> userEntitys = leaveService.getAllLeaves(); 
		return userEntitys;
	}
		
	
	@PostMapping("/leaves")
	 public LeaveEntity createEmployee(@RequestBody LeaveEntity employee) {
       return leaveService.save(employee);
   }
	
	@PutMapping("/leaves/{id}")
	public LeaveEntity mapping(@PathVariable long id,@RequestBody LeaveEntity leave)
	{
		UserEntity userEntity=leaveService.getElementById(id);
		LeaveEntity leaveEntitys=new LeaveEntity();
		
		leaveEntitys.setDate(leave.getDate());
		leaveEntitys.setNumberOfDays(leave.getNumberOfDays());
		leaveEntitys.setReason(leave.getReason());
		leaveEntitys.setUserEntity(userEntity);
		
		return leaveService.save(leaveEntitys);
	}
	
	@PutMapping("/leave/{id}")
	public LeaveEntity getLeave(@PathVariable long id,@RequestBody LeaveEntity leave1)
	{
		Optional<LeaveEntity> leave=leaveService.findById(id);
		LeaveEntity leaveEntitys1=null;
		if(leave.isPresent())
		{
			leaveEntitys1=leave.get();
			leaveEntitys1.setApproved(leave1.getApproved());
			leaveEntitys1.setCancelled(leave1.getCancelled());
		}	
		
		return leaveService.save(leaveEntitys1);
	}
	
	@DeleteMapping("/leave/{id1}/{id}")
	public String deleteLeave(@PathVariable long id1,@PathVariable long id)
	{
		
		Optional<LeaveEntity> leaveEntity=leaveService.findById(id1);
		UserEntity userEntity=leaveService.getElementById(id);
		
		LeaveEntity leave=null;
		
		leave=leaveEntity.get();
		
		if(userEntity.getFirstName()==leave.getUserEntity().getFirstName())
		{
			if(leaveEntity.isPresent())
			{
				leave=leaveEntity.get();
				leaveService.delete(leave);
				leaveService.delete1(userEntity);
			}
		}
		
		return "deleted";
	}
}
