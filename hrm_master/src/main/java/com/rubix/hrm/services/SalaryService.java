package com.rubix.hrm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Salary;
import com.rubix.hrm.repository.SalaryRepository;

@Service
public class SalaryService {
	@Autowired
	private SalaryRepository SalaryRepository;

	public List<Salary> getallSalarys() {
		return (List<Salary>) SalaryRepository.findAll();
	}

	public Salary getSalarysById(long salaryId) {
		return SalaryRepository.findById(salaryId);
	}

	public Salary saveOrUpdate(Salary Salarys) {
		SalaryRepository.save(Salarys);
		return Salarys;
	}

	public String delete(long salaryId) {
		SalaryRepository.deleteById(salaryId);
		return "successfully deleted";
	}

	public String update(long salaryId, Salary Salarys) {
		Salary salary = SalaryRepository.findById(salaryId);
		salary.setJobId(Salarys.getJobId());
		salary.setAmount(Salarys.getAmount());
		salary.setAnnual(Salarys.getAnnual());
		salary.setBonus(Salarys.getBonus());
		SalaryRepository.save(salary);
		return "successfully updated";
	}

}
