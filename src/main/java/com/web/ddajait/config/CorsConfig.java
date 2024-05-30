package com.web.ddajait.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        // config.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // 포트를 명시적으로 설정
        config.addAllowedOriginPattern("http://localhost:*"); // Allow any port on localhost
        source.registerCorsConfiguration("/api/v1/**", config);
        return new CorsFilter(source);
    }
}