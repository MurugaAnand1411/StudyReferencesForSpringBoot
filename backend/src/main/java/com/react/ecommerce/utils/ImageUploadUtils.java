package com.react.ecommerce.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.react.ecommerce.constants.ProductConstants;



public class ImageUploadUtils {
	public static String uploadToLocalFileSystem(MultipartFile file,String foldername,String pathName) {
		/*
		 * we will extract the file name (with extension) from the given file to store
		 * it in our local machine for now and later in virtual machine when we'll
		 * deploy the project
		 */
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		/*
		 * The Path in which we will store our image . we could change it later based on
		 * the OS of the virtual machine in which we will deploy the project. In my case
		 * i'm using windows 10 .
		 */
		Path storageDirectory = Paths.get(ProductConstants.storageDirectoryPath+"/"+foldername);
		/*
		 * we'll do just a simple verification to check if the folder in which we will
		 * store our images exists or not
		 */
		if (!Files.exists(storageDirectory)) { // if the folder does not exist
			try {
				Files.createDirectories(storageDirectory); // we create the directory in the given storage directory
															// path
			} catch (Exception e) {
				e.printStackTrace();// print the exception
			}
		}

		Path destination = Paths.get(storageDirectory.toString() +"\\" + fileName);

		try {
			Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);// we are Copying all
																								// bytes from an input
																								// stream to a file

		} catch (IOException e) {
			e.printStackTrace();
		}
		// the response will be the download URL of the image
//		"product/images/getImage/"
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(pathName)
				.path(fileName).toUriString();
		// return the download image url as a response entity
		return fileDownloadUri;
	}

	public static  byte[] getImageWithMediaType(String imageName,String foldername) throws IOException {
		Path destination = Paths.get(ProductConstants.storageDirectoryPath + "\\"+foldername+"\\" + imageName);// retrieve the image by
																								// its name

		return IOUtils.toByteArray(destination.toUri());
	}
	
}
