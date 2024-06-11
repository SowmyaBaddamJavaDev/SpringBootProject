package com.sgb.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgb.www.model.Customer;
import com.sgb.www.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		Customer cust = customerService.addCustomer(customer);
		
		System.out.println("TEST complete");
		
		return cust;
		
	}

	
	@GetMapping("/fetch")
	public List<Customer> fetchCustomer() {
		
		List<Customer> cust = customerService.fetchCustomer();
		
		System.out.println("TEST read complete");
		
		return cust;
		
	}
}
