package com.rubix.react.audit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.react.audit.entities.Bill;
import com.rubix.react.audit.service.BillService;

@RestController
@RequestMapping("/customer/bill")
public class BillController {

	BillService billService;

	public BillController(BillService billService) {
		super();
		this.billService = billService;
	}

	@PostMapping
	public String saveBill(@RequestBody Bill bill) {
		Optional<Bill> billDb=billService.create(bill);
		if(billDb.isPresent()) {
			return "The Bill data has been saved successfully!";
		}
		else {
			return "Bill data already exist in records";
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") long id){
		Optional<Bill> billDb =billService.retrieveOne(id);
		if(billDb.isPresent()) {
			return new ResponseEntity<>(billDb.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Bill> getAllBill(){
		return billService.retrieve();
	}

	@PutMapping("/{id")
	public String updateBill(@RequestBody Bill bill) {
		Optional<Bill> bill1 =billService.update(bill);
		if(bill1.isEmpty()) {
			return "The Bill data does not exist in records!";
		}
		else {
			return "The bill data has beeb updated successfully!";
		}

	}

	@DeleteMapping("/{id}")
	public String deleteBillById(@PathVariable("id") Long id) {
		return billService.delete(id);
	}

}
