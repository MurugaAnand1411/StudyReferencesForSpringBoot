package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SeedDb {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
    public SeedDb(DataSource dataSource) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into Student (stuName, total, region) values (?, ?, ?)", new Object[]{"James", 63, "London"});
        jdbcTemplate.update("insert into Student (stuName, total, region) values (?, ?, ?)", new Object[]{"Marie", 71, "Edinburgh"});
        jdbcTemplate.update("insert into Student (stuName, total, region) values (?, ?, ?)", new Object[]{"Peter", 80, "Belfast"});
        jdbcTemplate.update("insert into Student (stuName, total, region) values (?, ?, ?)", new Object[]{"selore", 78, "USA"});
        jdbcTemplate.update("insert into Student (stuName, total, region) values (?, ?, ?)", new Object[]{"Sally", 89, "Cardiff"});
        jdbcTemplate.update("insert into Student (stuName, total, region) values (?, ?, ?)", new Object[]{"Peter", 101, "London"});
        
        
    }
}

