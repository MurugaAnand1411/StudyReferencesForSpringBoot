package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}