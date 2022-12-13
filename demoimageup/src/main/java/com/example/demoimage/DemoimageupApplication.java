package com.example.demoimage;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demoimage.controller.ImageUploadController;

@SpringBootApplication
@ComponentScan({"com.example.demoimage","controller"})
public class DemoimageupApplication {

	public static void main(String[] args) {
		new File(ImageUploadController.uploadDirectory).mkdir();
		SpringApplication.run(DemoimageupApplication.class, args);
	}

}
