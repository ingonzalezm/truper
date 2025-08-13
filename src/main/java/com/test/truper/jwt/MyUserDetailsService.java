package com.test.truper.jwt;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        if ("user".equals(username)) {
        	UserDetails u = new org.springframework.security.core.userdetails.User(
                "user", "password", new ArrayList<>());
            return u;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    
}

