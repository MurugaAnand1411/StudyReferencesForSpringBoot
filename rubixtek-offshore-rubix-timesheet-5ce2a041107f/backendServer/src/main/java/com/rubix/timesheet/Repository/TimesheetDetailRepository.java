package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.rubix.timesheet.Domain.TimesheetDetail;

@Repository
public interface TimesheetDetailRepository extends JpaRepository<TimesheetDetail, Long> {
	TimesheetDetail findByTimesheetDetailId(long id);
	
	@Query(value = "SELECT * from timesheetdetail  WHERE  timesheet_id=:id", nativeQuery = true)
	List<TimesheetDetail> getByTimesheetId(@Param("id") Long id);
	
}
