package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Official;
@Repository
public interface OfficialRepository extends JpaRepository<Official,Long>{

}
