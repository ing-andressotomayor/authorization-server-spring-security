package com.example.oauthserver.persistence;

import com.example.oauthserver.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByClientId(String clientId);
}
