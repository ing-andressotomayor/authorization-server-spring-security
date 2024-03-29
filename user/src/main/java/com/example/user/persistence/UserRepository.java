package com.example.user.persistence;

import com.example.user.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by Andrés Sotomayor Venegas on 25/03/2024.
 * spring-security-authorization-server-oauth2
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByEmail(String email);
    Mono<Boolean> existsByEmail(String email);
}
