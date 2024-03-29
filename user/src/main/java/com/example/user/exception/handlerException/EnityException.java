package com.example.user.exception.handlerException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Andrés Sotomayor Venegas on 28/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnityException {
    private String cause;
    private LocalDate date;

}
