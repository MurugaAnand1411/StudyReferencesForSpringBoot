package com.rubix.react.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.react.audit.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
