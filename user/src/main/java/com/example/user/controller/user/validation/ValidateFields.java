package com.example.user.controller.user.validation;

import com.example.user.entity.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

/**
 * Created by Andrés Sotomayor Venegas on 27/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Service
public class ValidateFields {
    @Autowired
    private Validator validator;

    public Mono<ServerResponse> validate(Errors errors){

        return ServerResponse.badRequest().bodyValue(errors.getFieldErrors().stream().map(error->{
            return Validate.builder()
                    .field(error.getField())
                    .message(error.getDefaultMessage())
                    .date(LocalDate.now())
                    .build();
        }));
    }
}
