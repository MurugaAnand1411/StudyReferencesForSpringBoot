package com.rubix.react.audit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rubix.react.audit.entities.Bill;
import com.rubix.react.audit.repository.BillRepository;


@Service
public class BillService {
	
	BillRepository billRepository;

	public BillService(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}
	
	
	public Optional<Bill> create(Bill bill){
		return Optional.of(billRepository.save(bill));
	}
	
	public List<Bill> retrieve(){
		return billRepository.findAll();
	}
	
	public Optional<Bill> retrieveOne(long billId){
		return billRepository.findById(billId);
	}
	public Optional<Bill> update(Bill bill){
		if(billRepository.existsById(bill.getBillId())){
		return Optional.of(billRepository.save(bill));
	}
	else {
		return Optional.empty();	
		}
	}
	
	public String delete(Long billId) {
		if(billRepository.existsById(billId)) {
			billRepository.deleteById(billId);
			return billId+"deleted successfully";
		}else {
			return "the bill datadoes not exist in records!";
		}
	}

}
