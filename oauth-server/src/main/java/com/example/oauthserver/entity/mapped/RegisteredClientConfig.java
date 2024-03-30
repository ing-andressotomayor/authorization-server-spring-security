package com.example.oauthserver.entity.mapped;

import com.example.oauthserver.entity.client.Client;
import com.example.oauthserver.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * Created by Andrés Sotomayor Venegas on 29/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Service
public class RegisteredClientConfig {
    @Autowired
    private ClientRepository cliRepo;
    public RegisteredClient clientRepository (String id){

        //Recupera el cliente de la db
        Client client = cliRepo.findByClientId(id).orElseThrow();
        return RegisteredClient.withId(client.getClientId())
                // Se inserta el client_id del objeto client
                .clientId(client.getClientId())
                // Se inserta el client_name del objecto client
                .clientName(client.getName())
                // Se itera el Set RedirectUris del objeto client, se extrae el valor del string y se insertan en el set del mapper
                .redirectUris(uris-> client.getRedirectUris().forEach(uri-> uris.add(uri.getUri())))
                //Se itera el Set scope del objeto client, se extrae el valor del string y se insertan en el set del mapper
                .scopes(scopes-> client.getScopes().forEach(scope-> scopes.add(scope.getName())))
                //Se itera el Set authorizationGrantTypes del objeto client, se extrae el valor del string y se insertan en el set del mapper
                .authorizationGrantTypes(grantTypes-> client.getAuthorizationGrantTypes().forEach(grantType->grantTypes.add(new AuthorizationGrantType(grantType.getName()))))
                //Se itera el Set AuthenticationMethods del objeto client, se extrae el valor del string y se insertan en el set del mapper
                .clientAuthenticationMethods(methods-> client.getClientAuthenticationMethods().forEach(method->methods.add(new ClientAuthenticationMethod(method.getName()))))
                // Se inserta el client_secret del objecto client
                .clientSecret(client.getClientSecret())
                // Se asigna un tiempo de vida de 4 min al access token
                .tokenSettings(TokenSettings.builder().accessTokenTimeToLive(client.getLiveAccessToken()).build())
                // Se asigna la casilla de alcances a los que accedera el cliente, esta se mostrara al usuario final
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(client.isClientSettings()).build())
                .build();
    }
}
