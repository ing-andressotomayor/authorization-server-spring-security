package com.example.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@RestController
public class TestController {
    @GetMapping
    public Map<String,String> test(){
        return Map.of("Estado","Autenticado");
    }
}
