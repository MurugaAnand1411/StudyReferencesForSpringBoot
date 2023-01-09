package com.rubix.timesheet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.DateRange;

@Repository
public interface DateRangeRepository extends JpaRepository<DateRange, Long> {

	@Query(value = "SELECT * from daterange  WHERE  timesheetdetail_id=:id order by date_range_id asc", nativeQuery = true)
	List<DateRange> getByTimesheetDetailId(@Param("id")Long timesheetDetailId);
}