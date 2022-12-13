package com.rubix.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.hrm.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
