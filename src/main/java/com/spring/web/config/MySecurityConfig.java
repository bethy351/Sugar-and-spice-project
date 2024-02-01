package com.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.spring.web.UserService;
 
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
 
    private final UserService userService;
 
    public MySecurityConfig(UserService userService) {
        this.userService = userService;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf()
                .ignoringAntMatchers("/customer/**") // Disable CSRF for customer endpoints
                .ignoringAntMatchers("/restaurant/**")
                .and()
            .authorizeRequests()
            .antMatchers("/error").permitAll()
            .antMatchers("/customer/**").hasRole("CUSTOMER")
            .antMatchers("/restaurant/**").hasRole("ADMIN")
            .antMatchers("/driver/**").hasRole("DRIVER")
            .anyRequest().authenticated() // This should be the last in the chain
            .and()
            .httpBasic();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}