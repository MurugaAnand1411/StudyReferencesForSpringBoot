package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;








@Service
public class ProductService {
	@Autowired
	private static ProductRepos prodRepo;
	
//	public void customMethod() {
//		ProductModel newpro =new ProductModel(1,"Iphone13", "ios processer with 128 gb ram", "yes", 70000);
//		newpro = prodRepo.save(newpro);	
//	}

	private static void allproducts(String message, Iterable<ProductRepos> prodRepos) {
		List<ProductModel> employees = prodRepo.findByPriceAndProductname(1, message);
		System.out.printf("\n%s\n", message);
		for (ProductRepos employees1: prodRepos) {
			System.out.println(employees1);
		}
	}
	
}
	
	
	
	

//	public void useStandardRepoMethods() {

		// Insert an employee.
//		ProductModel newEmp = new ProductModel(-1, "Iphone13", "ios processer with 128 gb ram", "yes", 70000);
//		newEmp = prodRepo.save(newEmp);
//		System.out.printf("Inserted product, id %d\n", newEmp.getProductId());

//		// Get count of all employees.
//		System.out.printf("There are now %d product\n", prodRepo.count());
//
//		 Get all employees.
		//displayProduct("All products: ", prodRepo.findAll());
//		
//
//	}
//	
//		
//		List<ProductModel> emps = prodRepo.findByPriceAndProductname(70000,  "Iphone13");
//		displayProduct("Employees earning 20k to 50k: ", emps);		
//	}
//	public void useCustomQueryMethods() {
//
//		/*
//		 * // Get all employees by region. displayEmployees("All employees in London: ",
//		 * repository.findByRegion("London"));
//		 * 
//		 * System.out.println();
//		 * 
//		 * // Get employees by salary range. List<Employee> emps =
//		 * repository.findInDhuttuRange(20000, 50000);
//		 * displayEmployees("Employees earning 20k to 50k: ", emps);
//		 * 
//		 */
//
//		// Get a page of employees.
//		Pageable pageable = PageRequest.of(0, 3, Direction.DESC, "price");
//		Page<ProductModel> page = prodRepo.findByPriceGreaterThan(50000, pageable);
//		displayProduct("Page 1 of employees more than 50k ", page.getContent());
//
//		pageable = PageRequest.of(1, 3, Direction.DESC, "price");
//		page = prodRepo.findByPriceGreaterThan(50000, pageable);
//		displayProduct("Page 2 of employees more than 50k ", page.getContent());
//
//		pageable = PageRequest.of(2, 3, Direction.DESC, "price");
//		page = prodRepo.findByPriceGreaterThan(50000, pageable);
//		displayProduct("Page 3 of employees more than 50k ", page.getContent());
//
//		pageable = PageRequest.of(3, 3, Direction.DESC, "price");
//		page = prodRepo.findByPriceGreaterThan(50000, pageable);
//		displayProduct("Page 4 of employees more than 50k ", page.getContent());
//
//		 System.out.println("No of pages is " + page.getTotalPages() + " get Total Elements " + page.getTotalElements()
//		 + " current page " + page.getNumber());
//
//		System.out.println();
//
//	}
//
//	private void displayProduct(String message, Iterable<ProductModel> employees) {
//		System.out.printf("\n%s\n", message);
//		for (ProductModel emp: employees) {
//			System.out.println(emp);
//		}
//	}

//}
