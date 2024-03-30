package com.example.client.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@EnableWebSecurity
@Configuration
public class Routes {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(routes->routes.anyRequest().authenticated())
                .oauth2Login(loging->loging.loginPage("/oauth2/authorization/test")).build();
    }
}
