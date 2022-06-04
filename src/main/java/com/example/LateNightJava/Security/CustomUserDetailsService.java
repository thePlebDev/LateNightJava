package com.example.LateNightJava.Security;

import com.example.LateNightJava.Models.User;
import com.example.LateNightJava.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = ()-> new UsernameNotFoundException("Problem during authentication");
        System.out.println("WE ARE IN loadUserByUsername");
        User returnedUser = userRepository.findByUsername(username).orElseThrow(s);

        return new SecurityUser(returnedUser);
    }
}
