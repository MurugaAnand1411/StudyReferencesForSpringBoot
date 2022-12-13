package com.rubix.react.audit.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/recipt")
public class FileImageUploadController {

	 @PostMapping("/upload-file")
	    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
	        System.out.println(file.getOriginalFilename());
	        System.out.println(file.getName());
	        System.out.println(file.getContentType());
	        System.out.println(file.getSize());
	        String path_Directory =new ClassPathResource("static/image").getFile().getAbsolutePath();
	        Files.copy(file.getInputStream(),Paths.get(path_Directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	        return "Successfully Image is Uploaded";

	    }
}
