package com.example.user.exception.exceptionClass;

/**
 * Created by Andrés Sotomayor Venegas on 26/03/2024.
 * spring-security-authorization-server-oauth2
 */
public class UserRepeatException extends Exception{
    public UserRepeatException(String message) {
        super(message);
    }
}
