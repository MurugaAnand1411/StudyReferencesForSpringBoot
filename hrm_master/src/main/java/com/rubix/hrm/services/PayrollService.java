package com.rubix.hrm.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Payroll;
import com.rubix.hrm.repository.PayrollRepository;

@Service
public class PayrollService {
	@Autowired
	private PayrollRepository payrollRepository;

	public List<Payroll> getallPayrolls() {
		return (List<Payroll>) payrollRepository.findAll();
	}

	public Payroll getpayrollsById(long payrollId) {
		return payrollRepository.findById(payrollId);
	}

	public Payroll saveOrUpdate(Payroll payrolls) {
		payrollRepository.save(payrolls);
		return payrolls;
	}

	public String delete(long payrollId) {
		payrollRepository.deleteById(payrollId);
		return "successfully deleted";
	}

	public String update(long payrollId, Payroll payrolls) {
		Payroll payroll = payrollRepository.findById(payrollId);
		payroll.setEmpId(payrolls.getEmpId());
		payroll.setJobId(payrolls.getJobId());
		payroll.setLeaveId(payrolls.getLeaveId());
		payroll.setPayrollId(payrolls.getPayrollId());
		payroll.setSalaryId(payrolls.getSalaryId());
		payroll.setReport(payrolls.getReport());
		payroll.setTotalAmount(payrolls.getTotalAmount());
		payrollRepository.save(payroll);
		return "successfully updated";
	}
}