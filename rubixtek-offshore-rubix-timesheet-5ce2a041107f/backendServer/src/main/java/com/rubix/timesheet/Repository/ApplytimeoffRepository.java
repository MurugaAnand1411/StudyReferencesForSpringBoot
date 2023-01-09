package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Applytimeoff;

@Repository
public interface ApplytimeoffRepository extends JpaRepository<Applytimeoff, Long> {

}
