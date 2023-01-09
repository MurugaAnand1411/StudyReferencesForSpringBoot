package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Qualification;
@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Long>{

}
