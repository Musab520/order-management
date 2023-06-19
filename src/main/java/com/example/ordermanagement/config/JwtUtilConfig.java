package com.example.ordermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.ordermanagement.util.JwtUtil;

@Configuration
public class JwtUtilConfig {
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
