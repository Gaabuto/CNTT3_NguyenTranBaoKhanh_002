package com.example.demo.src.security.config;

import com.example.demo.src.security.JwtAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtAuthenticationEntryPoint entryPoint) throws Exception {

        http
                .exceptionHandling(exception ->
                        exception.authenticationEntryPoint(entryPoint));

        return http.build();
    }
}