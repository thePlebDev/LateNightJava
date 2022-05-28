package com.example.LateNightJava.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails authUser = userDetailsService.loadUserByUsername(username);

        if(bCryptPasswordEncoder.matches(password,authUser.getPassword())){
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    authUser.getAuthorities()
            );
        }else{
            throw new BadCredentialsException("Something went wrong");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
