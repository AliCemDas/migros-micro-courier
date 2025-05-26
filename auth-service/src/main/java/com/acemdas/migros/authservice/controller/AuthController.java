package com.acemdas.migros.authservice.controller;


import com.acemdas.migros.authservice.dto.LoginRequest;
import com.acemdas.migros.authservice.dto.LoginResponse;
import com.acemdas.migros.authservice.dto.TokenValidationRequest;
import com.acemdas.migros.authservice.dto.TokenValidationResponse;
import com.acemdas.migros.authservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    // Static username-password
    private static final String STATIC_USERNAME = "admin";
    private static final String STATIC_PASSWORD = "password";

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
            if (STATIC_USERNAME.equals(request.getUsername()) && STATIC_PASSWORD.equals(request.getPassword())) {
            String token = jwtService.generateToken(request.getUsername());
            return ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenValidationResponse> validate(@RequestHeader("Authorization") String token) {
        boolean isValid = jwtService.validateToken(token.substring(7));
        return ResponseEntity.ok(new TokenValidationResponse(isValid));
    }

}
