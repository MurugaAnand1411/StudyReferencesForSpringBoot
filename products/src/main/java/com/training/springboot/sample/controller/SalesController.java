package com.training.springboot.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.springboot.sample.entities.Product;
import com.training.springboot.sample.entities.Sale;
import com.training.springboot.sample.entities.User;
import com.training.springboot.sample.service.ProductService;
import com.training.springboot.sample.service.SalesService;
import com.training.springboot.sample.service.UserService;

@Controller
public class SalesController {

	@Autowired
	private SalesService salesService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/sales")
	public String viewHomePage(Model model) {
		List<Sale> listSales = salesService.listAll();
		model.addAttribute("listSale", listSales);
		
		return "sales";
	}
	
	@RequestMapping("/myorders")
	public String getUserOrders(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		System.out.println("Logged in username is " + userName );
		User user = userService.findByEmail(userName);
		
		List<Sale> listSales = salesService.getOrdersForUser(user);
		model.addAttribute("listSale", listSales);
		
		return "orders";
		
	}
	
	@RequestMapping("/buy/{id}")
	public ModelAndView showNewSalesPage(@PathVariable(name = "id") int id) {
		
		
		
		Sale sale = new Sale();
		
		//-- First get the product
		Product product = productService.get(id);
		sale.setProduct(product);
		
		//-- Now get the logged in user
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		System.out.println("Logged in username is " + userName );
		User user = userService.findByEmail(userName);
		sale.setUser(user);
		
		ModelAndView modelAndView = new ModelAndView("new_sale");
	    modelAndView.addObject("sale", sale);
	    return modelAndView;
	
	}
	
	@RequestMapping(value = "/savesale", method = RequestMethod.POST)
	public String saveTheSale(@ModelAttribute("sale") Sale sale) {
		
		System.out.println(sale.getProduct().getName());
		System.out.println(sale.getProduct().getId());
		Product product = productService.get(sale.getProduct().getId());
		
		Sale toSave = new Sale();
		toSave.setProduct(product);
		toSave.setQuantity(sale.getQuantity());
		toSave.setAmount(sale.getAmount());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		System.out.println("Logged in username is " + userName );
		User user = userService.findByEmail(userName);
		toSave.setUser(user);
		
		salesService.save(toSave);
		
		return "redirect:/sales";
	}
	
	@RequestMapping("/deletesale/{id}")
	public String deleteSale(@PathVariable(name = "id") int id) {
		salesService.delete(id);
		return "redirect:/sales";		
	}
}
