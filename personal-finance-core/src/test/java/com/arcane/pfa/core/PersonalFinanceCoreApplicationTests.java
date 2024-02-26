package com.arcane.pfa.core;

import com.arcane.pfa.core.domain.UserDetails;
import com.arcane.pfa.core.exception.UserDetailsException;
import com.arcane.pfa.core.repository.UserDetailsRepository;
import com.arcane.pfa.core.service.UserDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Executable;

@SpringBootTest
class PersonalFinanceCoreApplicationTests {

    @Autowired
    private UserDetailsService userDetailsService;

    @MockBean
    private UserDetailsRepository repository;

    /**
     * Test for behaviour of findUserDetailsByEmail if repository returns non-null value
     */
    @Test
    public void testUserExistsCheck(){
        Mockito.when(repository.findUserDetailsByEmail(Mockito.anyString())).thenReturn(new UserDetails());
        UserDetails userDetails = userDetailsService.checkUserStatus("test-user");
        assertTrue(userDetails!=null);
    }
    /**
     * Test for behaviour of findUserDetailsByEmail if repository returns null value
     */
    @Test
    public void testUserDoesNotExistsCheck(){
        Mockito.when(repository.findUserDetailsByEmail(Mockito.anyString())).thenReturn(null);
        assertThrowsExactly(UserDetailsException.class, () -> userDetailsService.checkUserStatus("test-user"));
    }
}
