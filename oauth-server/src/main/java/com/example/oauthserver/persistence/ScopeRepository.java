package com.example.oauthserver.persistence;

import com.example.oauthserver.entity.client.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
public interface ScopeRepository extends JpaRepository<Scope,Long> {
}
