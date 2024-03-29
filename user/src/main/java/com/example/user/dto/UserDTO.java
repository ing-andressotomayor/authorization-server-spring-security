package com.example.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Andrés Sotomayor Venegas on 25/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Size(min = 5,max = 12)
    private String username;
    @Size(min = 5,max = 12)
    private String password;
    @Email
    @Indexed(unique = true)
    private String email;
}
