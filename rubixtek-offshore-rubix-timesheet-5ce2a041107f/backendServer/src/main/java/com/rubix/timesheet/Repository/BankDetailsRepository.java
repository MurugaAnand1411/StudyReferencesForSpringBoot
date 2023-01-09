package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Bankdetails;
@Repository
public interface BankDetailsRepository extends JpaRepository<Bankdetails,Long>{

}
