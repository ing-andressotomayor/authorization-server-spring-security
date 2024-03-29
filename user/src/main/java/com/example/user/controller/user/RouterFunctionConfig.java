package com.example.user.controller.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * Created by Andrés Sotomayor Venegas on 26/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse>route (UserController controller){
        return RouterFunctions.route(RequestPredicates.POST("/create"), controller::create);
    }
}
