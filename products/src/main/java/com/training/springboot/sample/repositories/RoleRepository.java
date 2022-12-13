package com.training.springboot.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springboot.sample.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String name);
}
