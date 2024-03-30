package com.example.oauthserver.entity.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "redirect_uris")
@Builder
public class RedirectURI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_redirect_uri")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String uri;
}
