package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.Dancer;

public interface DancerRepo  extends JpaRepository<Dancer, Long> {

}
