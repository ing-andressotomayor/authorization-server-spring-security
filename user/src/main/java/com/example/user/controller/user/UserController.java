package com.example.user.controller.user;

import com.example.user.dto.UserDTO;
import com.example.user.entity.User;
import com.example.user.exception.exceptionClass.UserRepeatException;
import com.example.user.persistence.UserRepository;
import com.example.user.controller.user.validation.ValidateFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.Set;

/**
 * Created by Andrés Sotomayor Venegas on 25/03/2024.
 * spring-security-authorization-server-oauth2
 */
@Service
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private Validator validator;
    @Autowired
    private ValidateFields validateFields;

    @Value("${authority.user}")
    private  String AUTHORITY;
    @Value("${message.exception}")
    private String MESSAGE_EXCEPTION;

    //Create a User
    public Mono<ServerResponse> create(ServerRequest request) {

        return request.bodyToMono(UserDTO.class)
                .flatMap(user -> {
                    Errors error = new BeanPropertyBindingResult(user, UserDTO.class.getName());
                    validator.validate(user, error);
                    if (error.hasErrors()) {
                        return validateFields.validate(error);
                    }
                    return repository.existsByEmail(user.getEmail()).flatMap(verifyIfUserIsRepeat -> {
                        if (verifyIfUserIsRepeat) return Mono.error(new UserRepeatException(MESSAGE_EXCEPTION));

                        User userSave = User.builder()
                                .username(user.getUsername())
                                .password(encoder.encode(user.getPassword()))
                                .email(user.getEmail())
                                .authorities(Set.of(new SimpleGrantedAuthority(AUTHORITY)))
                                .build();
                        return ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(repository.save(userSave), User.class);

                    });
                });
            }
        }
