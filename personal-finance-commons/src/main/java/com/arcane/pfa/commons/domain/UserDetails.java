package com.arcane.pfa.commons.domain;

import java.util.List;

import lombok.Data;


@Data
public class UserDetails {
	
	private String uid;
	private String name;
	private String email;
	private String password;
	private List<String> accounts;
	
}
