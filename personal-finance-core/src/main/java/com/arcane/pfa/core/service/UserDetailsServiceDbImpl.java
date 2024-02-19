package com.arcane.pfa.core.service;

import com.arcane.pfa.core.domain.UserDetails;
import com.arcane.pfa.core.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceDbImpl implements UserDetailsService{

    private UserDetailsRepository repository;
    @Override
    public void createUser(UserDetails userDetails) {
        repository.save(userDetails);
    }

    @Override
    public UserDetails checkUserStatus(String email) {
        UserDetails fetchedUserDetails = repository.findUserDetailsByEmail(email);

        if (fetchedUserDetails==null){
            throw new RuntimeException(String.format("UserDetails with email %s not found",email));
        }
        return fetchedUserDetails;
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return repository.findAll();
    }
    @Autowired
    public void setRepository(UserDetailsRepository repository) {
        this.repository = repository;
    }
}
