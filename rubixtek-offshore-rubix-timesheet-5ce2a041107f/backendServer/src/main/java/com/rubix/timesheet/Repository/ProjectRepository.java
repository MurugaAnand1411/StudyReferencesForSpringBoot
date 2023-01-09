package com.rubix.timesheet.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	Project findByProjectId(long id);
}