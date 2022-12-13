package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {
    
	List<Student> findByRegion(String region);
	//-- select * from employee where region = ?
	
	List<Student> findByRegionAndStuName(String region, String name);
	//-- select * from employee where region = ? and name = ?
	
	@Query("select s from Student s where region = ?1 or total  >= ?2")
	List<Student> findByRegionOrTotalGreaterThanEqual(String region, double total);
	
	@Query("select s from Student s where s.total >= ?1 and s.total <= ?2")
    List<Student> findInTotalRange(double from, double to);
	
	Page<Student> findByTotalGreaterThan(double total, Pageable pageable);
	
	Page<Student> findByTotalBetween(double from,double to,  Pageable pageable);
}

