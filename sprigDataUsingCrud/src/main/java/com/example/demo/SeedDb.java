package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SeedDb {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
    public SeedDb(DataSource dataSource) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	jdbcTemplate.update("insert into PRODUCT1 (name,quality_check,description,price) values (?, ?, ?, ?)", new Object[]{"Iphone13","NO", "ios processer with 128 gb ram", 90000});
    	jdbcTemplate.update("insert into PRODUCT1 (name,quality_check,description,price) values (?, ?, ?, ?)", new Object[]{"Iphone13","YES","ios processer with 64 gb ram", 80000});
    	jdbcTemplate.update("insert into PRODUCT1 (name,quality_check,description,price) values (?, ?, ?, ?)", new Object[]{"Iphone13ProMax","NO","ios processer with 256 gb ram", 150000});
    	jdbcTemplate.update("insert into PRODUCT1 (name,quality_check,description,price) values (?, ?, ?, ?)", new Object[]{"Apple Air pods plus","YES","bluetooth 5 ipv7 2H base booster", 13000});
    	jdbcTemplate.update("insert into PRODUCT1 (name,quality_check,description,price) values (?, ?, ?, ?)", new Object[]{"Boat wireless air posds","YES","bluetooth 5 ipv7 2H base booster battery 12h",4500});
    
    }
}
