package com.autosarthi.config; // ⚠️ Update this line to match your actual project package name

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Applies to your public, customer, mechanic, and admin endpoints
                        .allowedOrigins("*") // Permits requests from any origin for smooth testing
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Enables standard REST operations
                        .allowedHeaders("*") // Allows custom tokens like Bearer JWT headers
                        .maxAge(3600); // Caches the CORS response for 1 hour to optimize network traffic
            }
        };
    }
}
