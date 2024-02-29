package com.arcane.pfa.core.rest;

import com.arcane.pfa.core.aspect.ValidateEmail;
import com.arcane.pfa.core.domain.UserDetails;
import com.arcane.pfa.core.service.UserDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserDetailsController {


    private UserDetailsService service;
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserDetails userDetails){
        service.createUser(userDetails);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllUsers(@AuthenticationPrincipal OAuth2User oAuth2User){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/check-status")
    @Operation(summary = "Use this to check if user is created or not")
    @Tag(name="Check User Details", description = "User Details operations")
    @ValidateEmail
    public ResponseEntity<UserDetails> checkUserCreationStatus(@RequestParam String email, @AuthenticationPrincipal OAuth2User oAuth2User){
        log.info("User Details : {}", oAuth2User.getAttributes().get("login"));
        return ResponseEntity.ok(service.checkUserStatus(email));
    }

    @Autowired
    public void setService(UserDetailsService service) {
        this.service = service;
    }
}
