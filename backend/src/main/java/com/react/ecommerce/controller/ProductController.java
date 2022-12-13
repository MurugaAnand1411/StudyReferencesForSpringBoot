package com.react.ecommerce.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.react.ecommerce.domain.Category;
import com.react.ecommerce.domain.Product;
import com.react.ecommerce.service.ProductService;
import com.react.ecommerce.utils.ImageUploadUtils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "images/getImage/{imageName:.+}", produces = { MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE })

	public @ResponseBody byte[] getImages(@PathVariable(name = "imageName") String fileName) throws IOException {
		return ImageUploadUtils.getImageWithMediaType(fileName, "products");

	}
	@GetMapping("/getProductList/byName")
	public List<Product> getProductListByName(@RequestParam String productName ) {
		return productService.getProductListByName(productName);
	}
	@GetMapping("/getAll")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {
		return productService.getAllCategory();
	}
	
	@PostMapping("/saveProduct/{categoryId}")
	public String addProduct(@PathVariable(value = "categoryId", required = true) long categoryId,@RequestBody Product product) {
		return productService.addProduct(categoryId, product);
	}
	@PostMapping("/saveCategory")
	public String addCategory(@RequestBody Category categoy) {
		return productService.addCategory(categoy);
	}
	@GetMapping("/getProductDetail/{productId}")
	public Optional<Product> getProductDetails(@PathVariable(value = "productId", required = true) long productId){
		return productService.getProductDetails(productId);
	}
	
	
	
	
	
	
	
	
	
	
}
