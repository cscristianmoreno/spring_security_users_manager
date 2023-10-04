package com.spring.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class Security {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return (
            httpSecurity
            .authorizeHttpRequests((req) -> {
                req.requestMatchers(HttpMethod.POST, "/create").permitAll();
                req.anyRequest().authenticated();  
            })
            .csrf((csrf) -> {
                csrf.disable();
            })
            .httpBasic(Customizer.withDefaults())
            .build()
        );
    } 
}
