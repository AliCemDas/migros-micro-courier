package com.acemdas.migros.authservice.service;

public interface JwtService {
    String generateToken(String username);

    boolean validateToken(String token);
}
