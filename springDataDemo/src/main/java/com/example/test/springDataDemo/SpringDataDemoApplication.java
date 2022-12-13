package com.example.test.springDataDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);

		EmployeeService service = context.getBean(EmployeeService.class);
		
		service.modifyEntities();
		
		service.queryEntities();
	}

}
