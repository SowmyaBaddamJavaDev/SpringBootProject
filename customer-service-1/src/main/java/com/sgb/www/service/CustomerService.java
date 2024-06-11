package com.sgb.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sgb.www.model.Customer;
import com.sgb.www.model.Post;
import com.sgb.www.model.User;
import com.sgb.www.model.UserPost;
import com.sgb.www.model.UserPostDetails;
import com.sgb.www.repo.CustomerRepository;

@Service
public class CustomerService {
	
	
	
	private final RestTemplate restTemplate;
	
	public CustomerService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public String callExternalAPI(String apiURL) {
		return restTemplate.getForObject(apiURL, String.class);
	}
	
	public List<UserPostDetails> getCombinedUserData() {
        String usersUrl = "https://jsonplaceholder.typicode.com/users";
        String postsUrl = "https://jsonplaceholder.typicode.com/posts";

        ResponseEntity<User[]> usersResponseEntity = restTemplate.getForEntity(usersUrl, User[].class);
        ResponseEntity<Post[]> postsResponseEntity = restTemplate.getForEntity(postsUrl, Post[].class);

        User[] users = usersResponseEntity.getBody();
        Post[] posts = postsResponseEntity.getBody();

        List<UserPostDetails> combinedData = new ArrayList<>();

        for (User user : users) {
            for (Post post : posts) {
                if (user.getId() == post.getId()) {
                    combinedData.add(new UserPostDetails(
                            user.getId(),
                            user.getAddress().getGeo().getLat(),
                            user.getAddress().getGeo().getLng(),
                            post.getTitle(),
                            post.getBody()
                    ));
                    break;
                }
            }

        
    }
		return combinedData;
	
	
	}
	
	
	@Autowired
	CustomerRepository customerRepository;
	
public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
		
	}

public List<Customer> fetchCustomer() {
		
		return customerRepository.findAll();
}
	
	
}
