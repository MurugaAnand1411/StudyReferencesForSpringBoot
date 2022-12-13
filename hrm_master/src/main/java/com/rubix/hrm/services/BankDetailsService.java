package com.rubix.hrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.BankDetails;
import com.rubix.hrm.repository.BankRepository;

@Service
public class BankDetailsService {
	@Autowired
	private BankRepository bankRepository;

	public Optional<BankDetails> create(BankDetails bankDetails) {

		return Optional.of(bankRepository.save(bankDetails));

	}

	public List<BankDetails> retrieve() {
		return bankRepository.findAll();
	}

	public Optional<BankDetails> retrieveOne(Long bankId) {
		return bankRepository.findById(bankId);
	}

	public Optional<BankDetails> update(BankDetails bank) {
		if (bankRepository.existsById((bank.getBankId()))) {
			return Optional.of(bankRepository.save(bank));
		} else {
			return Optional.empty();
		}
	}

	public String delete(Long bankId) {
		if (bankRepository.existsById(bankId)) {
			bankRepository.deleteById(bankId);
			return bankId + " deleted successfully!";
		} else {
			return "The bank data does not exist in records!";
		}
	}

}
