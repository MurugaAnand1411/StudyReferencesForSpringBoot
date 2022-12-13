package com.rubix.hrm.repository;

import org.springframework.data.repository.CrudRepository;

import com.rubix.hrm.models.Jobdept;

public interface JobdeptRepository extends CrudRepository<Jobdept, Long> {
	Jobdept findById(long jobId);
}
