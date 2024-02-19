package com.arcane.pfa.core.service;

import com.arcane.pfa.core.domain.UserDetails;

import java.util.List;

public interface UserDetailsService {

    void createUser(UserDetails userDetails);
    UserDetails checkUserStatus(String email);
    List<UserDetails> getAllUsers();
}
