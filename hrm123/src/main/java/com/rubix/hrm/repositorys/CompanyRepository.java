package com.rubix.hrm.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.hrm.models.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {

}
