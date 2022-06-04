package com.example.LateNightJava.Security;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

    

    @Bean
    public AuthenticationProvider authenticationProvider(){
        return new CustomAuthenticationProvider();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests()
                .mvcMatchers("/blog-post/1").authenticated()
                .mvcMatchers("/blog-post/2").authenticated()
                .mvcMatchers("/").permitAll()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout().permitAll();

        return http.build();
    }


}
