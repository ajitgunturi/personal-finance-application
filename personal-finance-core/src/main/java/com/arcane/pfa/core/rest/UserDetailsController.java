package com.arcane.pfa.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.commons.domain.UserDetails;
import com.arcane.pfa.core.service.UserDetailsService;

@RestController
@RequestMapping("/users")
public class UserDetailsController {
	
	private UserDetailsService userDetailsService;
	
	@GetMapping
	public ResponseEntity<UserDetails> getUserDetails(){
		return ResponseEntity.ok(userDetailsService.getUserDetails());
	}
	@PostMapping
	public ResponseEntity<List<UserDetails>> addUser(@RequestBody UserDetails userDetails){
		return ResponseEntity.ok(userDetailsService.createUser(userDetails));
	}

	@Autowired
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	

}
