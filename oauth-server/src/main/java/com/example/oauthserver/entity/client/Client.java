package com.example.oauthserver.entity.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String name;
    private String clientId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String clientSecret;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean clientSettings;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Duration liveAccessToken;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "client_scope",joinColumns = @JoinColumn(name = "id_client"),inverseJoinColumns = @JoinColumn(name = "id_scope"))
    private Set<Scope> scopes;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<RedirectURI>redirectUris = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<AuthorizationGrantType>authorizationGrantTypes = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<AuthenticationMethod> clientAuthenticationMethods = new HashSet<>();
}
