package com.arcane.pfa.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arcane.pfa.commons.domain.UserDetails;

import jakarta.annotation.PostConstruct;

@Service
public class UserDetailsService {

	private UserDetails userDetails;
	private List<UserDetails> userDetailsList;
	
	@PostConstruct
	public void postConstruct() {
		userDetails = new UserDetails();
		userDetails.setName("Ajit");
		userDetails.setEmail("ajit.gunturi@gmail.com");
		userDetails.setAccounts(Arrays.asList("HDFC"));
		userDetailsList = new ArrayList<>();
	}
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public List<UserDetails> createUser(UserDetails newUser) {
		userDetailsList.add(newUser);
		return userDetailsList;
	}
	
}
