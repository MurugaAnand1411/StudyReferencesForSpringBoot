package com.rubix.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;

import com.rubix.timesheet.Domain.*;
import com.rubix.timesheet.Repository.*;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@SpringBootApplication
public class TimesheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rubix.timesheet")).build();
	}

}
@Component
class DemoCommandLineRunner implements CommandLineRunner{
	// private static final Logger logger = LoggerFactory.getLogger(DemoCommandLineRunner.class);

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public void run(String... args) throws Exception {

//		Role user = new Role();
//		user.setId(1);
//		user.setName(ERole.ROLE_EMPLOYEE);
//		roleRepo.save(user);
//		
//		Role admin = new Role();
//		admin.setId(2);
//		admin.setName(ERole.ROLE_ADMIN);
//		roleRepo.save(admin);
//		
//		Role hr = new Role();
//		hr.setId(3);
//		hr.setName(ERole.ROLE_HR);
//		roleRepo.save(hr);		
	}
	
}