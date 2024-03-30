package com.example.oauthserver.persistence;

import com.example.oauthserver.entity.client.AuthorizationGrantType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
public interface AuthorizationGrantTypeRepository extends JpaRepository<AuthorizationGrantType,Long> {
}
