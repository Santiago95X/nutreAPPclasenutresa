package com.example.NutreAPP.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                 // Todos los endpoints
                .allowedOriginPatterns("*")        // Cualquier origen (compatible con credenciales)
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD")
                .allowedHeaders("*")               // Cualquier cabecera en la petición
                .exposedHeaders("*")               // El frontend puede leer todas las cabeceras de la respuesta
                .allowCredentials(true)            // Permite cookies y cabecera Authorization
                .maxAge(3600);                     // Cachea el preflight (OPTIONS) por 1 hora
    }
}
