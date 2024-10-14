package com.example.wedding.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serve files from /uploads/ directory
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:/Users/maciejzuralski/Desktop/website/wedding/src/main/resources/static/");
    }
}

