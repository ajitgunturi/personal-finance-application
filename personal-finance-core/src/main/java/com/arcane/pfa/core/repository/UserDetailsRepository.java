package com.arcane.pfa.core.repository;

import com.arcane.pfa.core.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findUserDetailsByEmail(String email);
    UserDetails findUserDetailsByUsername(String username);
}
