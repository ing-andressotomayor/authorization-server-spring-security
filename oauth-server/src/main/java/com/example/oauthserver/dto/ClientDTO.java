package com.example.oauthserver.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    private String name;
    private String clientSecret;
    private Set<String> scope;
    private Set<String> redirectUri;
}
