package com.example.oauthserver.controller;

import com.example.oauthserver.dto.ClientDTO;
import com.example.oauthserver.entity.client.*;
import com.example.oauthserver.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@RestController
public class ClientController {
    @Autowired
    private ClientRepository clieRepo;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping(value = "/create")
    public ResponseEntity<Client> create(@RequestBody ClientDTO clientDTO){
        Client client = Client.builder()
                .name(clientDTO.getName())
                .scopes(clientDTO.getScope().stream().map(scope->  Scope.builder().name(scope).build()).collect(Collectors.toSet()))
                .redirectUris(clientDTO.getRedirectUri().stream().map(uri-> RedirectURI.builder().uri(uri).build()).collect(Collectors.toSet()))
                .clientId(UUID.randomUUID().toString())
                .clientSecret(encoder.encode(clientDTO.getClientSecret()))
                .clientAuthenticationMethods(Set.of(AuthenticationMethod.builder().name("client_secret_basic").build(),AuthenticationMethod.builder().name("client_secret_post").build()))
                .authorizationGrantTypes(Set.of(AuthorizationGrantType.builder().name("authorization_code").build()))
                .clientSettings(true)
                .liveAccessToken(Duration.ofMinutes(4L))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clieRepo.save(client));

    }

}
