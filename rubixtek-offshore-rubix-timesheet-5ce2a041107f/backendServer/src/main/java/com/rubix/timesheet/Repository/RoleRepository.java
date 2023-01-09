package com.rubix.timesheet.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.*;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
	Role findByName(ERole name);
}
