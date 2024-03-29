package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Andrés Sotomayor Venegas on 27/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Validate {
    private String field;
    private String message;
    private LocalDate date;
}
