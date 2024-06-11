package com.sgb.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgb.www.model.UserPost;
import com.sgb.www.model.UserPostDetails;
import com.sgb.www.service.CustomerService;

@RestController
@RequestMapping("/api")

public class ApiController {

	private final CustomerService customerService;
	
	@Autowired
	public ApiController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/dataCompare")
	public ResponseEntity<List<UserPostDetails>> callExternalAPI() {
		
		List<UserPostDetails> combinedData = customerService.getCombinedUserData();
	    return ResponseEntity.ok(combinedData);
	    }
	}



	
	

