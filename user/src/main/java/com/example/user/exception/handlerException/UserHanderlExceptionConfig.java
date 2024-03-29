package com.example.user.exception.handlerException;

import com.example.user.exception.exceptionClass.UserRepeatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

/**
 * Created by Andrés Sotomayor Venegas on 28/03/2024.
 * spring-security-authorization-server-oauth2
 */
@ControllerAdvice
public class UserHanderlExceptionConfig {

    @ExceptionHandler(UserRepeatException.class)
    public Mono<ResponseEntity<EnityException>> userRepeatException (UserRepeatException e){
        return Mono.just(ResponseEntity.badRequest().body(EnityException.builder().cause(e.getMessage()).date(LocalDate.now()).build()));
    }
}
