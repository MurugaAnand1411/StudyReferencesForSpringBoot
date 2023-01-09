package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
