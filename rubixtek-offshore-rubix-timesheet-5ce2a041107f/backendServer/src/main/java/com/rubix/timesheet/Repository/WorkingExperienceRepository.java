package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.WorkingExperience;
@Repository
public interface WorkingExperienceRepository extends JpaRepository<WorkingExperience,Long>{

}
