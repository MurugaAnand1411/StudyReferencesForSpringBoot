package com.rubix.timesheet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Holidaytimeoff;


@Repository
public interface HolidaytimeoffRepository extends JpaRepository<Holidaytimeoff, Long> {

}
