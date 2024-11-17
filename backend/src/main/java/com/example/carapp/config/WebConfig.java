package com.example.carapp.config;

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
                // Fetch allowed origins from environment variable or use default
                String allowedOrigins = System.getenv("ALLOWED_ORIGINS");
                if (allowedOrigins == null || allowedOrigins.isEmpty()) {
                    allowedOrigins = "http://localhost:3000"; // Default value for local development
                }

                registry.addMapping("/**")
                        .allowedOrigins(allowedOrigins.split(",")) // Support multiple origins
                        .allowedMethods("*") // Allow all HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow credentials like cookies or auth headers
            }
        };
    }
}
