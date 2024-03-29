package com.example.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by Andrés Sotomayor Venegas on 26/03/2024.
 * spring-security-authorization-server-oauth2
 */
@EnableWebFluxSecurity
@Configuration
public class Routes {
    @Bean
    public SecurityWebFilterChain filterChain (ServerHttpSecurity http){
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(filters->filters
                        .pathMatchers("/create").permitAll()
                        .anyExchange().authenticated()).build();
    }

}
