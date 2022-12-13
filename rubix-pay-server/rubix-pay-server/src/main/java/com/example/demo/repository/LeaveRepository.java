package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LeaveEntity;

@Repository
public interface  LeaveRepository extends JpaRepository<LeaveEntity,Long> {

}