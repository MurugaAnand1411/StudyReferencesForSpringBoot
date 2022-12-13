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

import com.rubix.hrm.models.Jobdept;
import com.rubix.hrm.services.JobdeptService;

@RestController
public class JobDeptController {
	@Autowired
	private JobdeptService JobdeptsService;

	@GetMapping("/jobdept")
	public List<Jobdept> getAllJobdepts() {
		return JobdeptsService.getallJobdepts();
	}

	@GetMapping("/jobdept/{jobId}")
	public Jobdept getJobdepts(@PathVariable("jobId") long jobId) {
		return JobdeptsService.getJobdeptsById(jobId);
	}

	@DeleteMapping("/jobdept/{jobId}")
	public String deleteJobdept(@PathVariable("jobId") long jobId) {
		return JobdeptsService.delete(jobId);
	}

	@PostMapping("/jobdepts")
	public Jobdept saveJobdept(@RequestBody Jobdept Jobdepts) {
		JobdeptsService.saveOrUpdate(Jobdepts);
		return Jobdepts;
	}

	@PutMapping("/jobdepts")
	public String update(@PathVariable("jobId") long jobId, @RequestBody Jobdept Jobdepts) {
		return JobdeptsService.update(jobId, Jobdepts);

	}
}
