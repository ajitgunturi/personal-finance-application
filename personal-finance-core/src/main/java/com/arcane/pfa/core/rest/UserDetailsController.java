package com.arcane.pfa.core.rest;

import com.arcane.pfa.core.domain.UserDetails;
import com.arcane.pfa.core.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailsController {


    private UserDetailsService service;
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserDetails userDetails){
        service.createUser(userDetails);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/check-status")
    public ResponseEntity<UserDetails> checkUserCreationStatus(@RequestParam String email){
        return ResponseEntity.ok(service.checkUserStatus(email));
    }

    @Autowired
    public void setService(UserDetailsService service) {
        this.service = service;
    }
}
