package com.rubix.hrm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Jobdept;
import com.rubix.hrm.repository.JobdeptRepository;

@Service
public class JobdeptService {
	@Autowired
	private JobdeptRepository JobdeptRepository;

	public List<Jobdept> getallJobdepts() {
		return (List<Jobdept>) JobdeptRepository.findAll();
	}

	public Jobdept getJobdeptsById(long jobId) {
		return JobdeptRepository.findById(jobId);
	}

	public Jobdept saveOrUpdate(Jobdept Jobdepts) {
		JobdeptRepository.save(Jobdepts);
		return Jobdepts;
	}

	public String delete(long jobId) {
		JobdeptRepository.deleteById(jobId);
		return "successfully deleted";
	}

	public String update(long jobId, Jobdept Jobdepts) {
		Jobdept job = JobdeptRepository.findById(jobId);
		job.setJobDept(Jobdepts.getJobDept());
		job.setName(Jobdepts.getName());
		job.setDescription(Jobdepts.getDescription());
		job.setSalaryRange(Jobdepts.getSalaryRange());
		JobdeptRepository.save(job);
		return "successfully updated";
	}

}
