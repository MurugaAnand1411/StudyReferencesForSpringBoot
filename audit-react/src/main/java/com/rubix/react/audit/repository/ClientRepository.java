package com.rubix.react.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.react.audit.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{


}
