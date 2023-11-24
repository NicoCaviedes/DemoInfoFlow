package com.quatrosphere.authservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.NEVER))
            .authorizeHttpRequests(request -> {
                request.requestMatchers(HttpMethod.GET, "/actuator").permitAll();
                request.requestMatchers(HttpMethod.POST, "/login", "/register").permitAll();
                request.requestMatchers(HttpMethod.PUT, "/login", "/register").permitAll();
                request.anyRequest().authenticated();
            });

        return http.build();
    }
}
