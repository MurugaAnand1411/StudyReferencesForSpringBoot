package com.rubix.react.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.react.audit.entities.Bill;

public interface BillRepository  extends JpaRepository<Bill, Long>{

}
