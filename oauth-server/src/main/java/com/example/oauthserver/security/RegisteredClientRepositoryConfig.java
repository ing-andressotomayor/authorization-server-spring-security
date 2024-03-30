package com.example.oauthserver.security;

import com.example.oauthserver.entity.mapped.RegisteredClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Service
public class RegisteredClientRepositoryConfig implements RegisteredClientRepository {
    @Autowired
    private RegisteredClientConfig regiClientConf;
    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return regiClientConf.clientRepository(id);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return regiClientConf.clientRepository(clientId);
    }
}
