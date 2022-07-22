package com.santiagocoggiolaportfolio.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication   
@EnableAutoConfiguration
@ComponentScan("com.santiagocoggiolaportfolio.service")
@ComponentScan(basePackages={"com.santiagocoggiolaportfolio.controller", "com.santiagocoggiolaporfolio.service", "com.santiagocoggiolaportfolio.model"})
@EnableJpaRepositories(basePackages="com.santiagocoggiolaportfolio.repository")
@EntityScan(basePackages="com.santiagocoggiolaportfolio.model")
@EnableTransactionManagement
@EnableWebMvc
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS", "HEAD", "PATCH").allowCredentials(true);
                }
            };
        }
}
