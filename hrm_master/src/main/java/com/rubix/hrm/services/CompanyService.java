package com.rubix.hrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Company;
import com.rubix.hrm.repository.CompanyRepository;

@Service

public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Optional<Company> create(Company company) {
			return Optional.of(companyRepository.save(company));
	}

	public List<Company> retrieve() {
		return companyRepository.findAll();
	}

	public Optional<Company> retrieveOne(long comId) {
		return companyRepository.findById(comId);
	}

	public Optional<Company> update(Company company) {
		
			return Optional.of(companyRepository.save(company));
	}

	public String delete(Long comId) {
		if (companyRepository.existsById(comId)) {
			companyRepository.deleteById(comId);
			return comId + " deleted successfully!";
		} else {
			return "The company data does not exist in records!";
		}

	}

}
