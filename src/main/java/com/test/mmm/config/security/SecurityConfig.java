package com.test.mmm.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.test.mmm.repository.UserRepository;
import com.test.mmm.service.InitUserCreateService;

/**
 * Created by Marian_Mykhalchuk on 9/4/2015.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/users/**").access("isAuthenticated()").antMatchers("/results/**")
                .access("isAuthenticated()").and().formLogin();
    }

    @Autowired
    @Bean
    public InitUserCreateService initUserCreateService(UserRepository userRepository) {
        return new InitUserCreateService(userRepository);
    }
}
