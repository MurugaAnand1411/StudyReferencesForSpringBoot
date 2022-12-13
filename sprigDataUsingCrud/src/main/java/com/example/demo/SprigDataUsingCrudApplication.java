package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SprigDataUsingCrudApplication {

	public static void main(String[] args) {
		//;
		ApplicationContext context = SpringApplication.run(SprigDataUsingCrudApplication.class, args);

		ProductService service = context.getBean(ProductService.class);
		//service.useCustomQueryMethods();
	service.allproducts();
		//service.useStandardRepoMethods();
	}

}
