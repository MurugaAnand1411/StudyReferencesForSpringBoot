package com.react.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.react.ecommerce.domain.Ecommuser;


@Repository
public interface EcommuserRepository extends JpaRepository<Ecommuser, Long> {

	Optional<Ecommuser> findByEmailId(String email);

	Ecommuser findByEmailIdAndPassword(String email, String pass);

	Ecommuser findByUserId(long id);

}
