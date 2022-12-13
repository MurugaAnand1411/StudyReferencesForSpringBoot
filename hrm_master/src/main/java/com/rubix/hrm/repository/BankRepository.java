package com.rubix.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.hrm.models.BankDetails;

public interface BankRepository extends JpaRepository<BankDetails, Long> {

}
