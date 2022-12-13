package com.rubix.hrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.hrm.models.Payroll;
import com.rubix.hrm.services.PayrollService;

@RestController
public class PayrollController {
	@Autowired
	private PayrollService payrollsService;

	@GetMapping("/payroll")
	public List<Payroll> getAllpayrolls() {
		return payrollsService.getallPayrolls();
	}

	@GetMapping("/payroll/{payrollid}")
	public Payroll getpayrolls(@PathVariable("payrollid") long payrollId) {
		return payrollsService.getpayrollsById(payrollId);
	}

	@DeleteMapping("/payroll/{payrollid}")
	public String deletepayroll(@PathVariable("payrollid") long payrollId) {
		return payrollsService.delete(payrollId);
	}

	@PostMapping("/payrolls")
	public Payroll savepayroll(@RequestBody Payroll payrolls) {
		payrollsService.saveOrUpdate(payrolls);
		return payrolls;
	}

	@PutMapping("/payroll/{payrollid}")
	public String update(@PathVariable("payrollid") long payrollId, @RequestBody Payroll payrolls) {
		return payrollsService.update(payrollId, payrolls);
	}
}
