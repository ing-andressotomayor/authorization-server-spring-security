package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * Created by Andrés Sotomayor Venegas on 25/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users_list")
public class User {
    @MongoId
    private String id;
    private String username;
    private String password;
    @Indexed(unique = true)
    private String email;
    private Set<GrantedAuthority> authorities;
}
