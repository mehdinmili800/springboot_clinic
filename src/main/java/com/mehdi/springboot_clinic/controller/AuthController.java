package com.mehdi.springboot_clinic.controller;

import com.mehdi.springboot_clinic.dto.JWTAuthResponse;
import com.mehdi.springboot_clinic.dto.StatusResponse;
import com.mehdi.springboot_clinic.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<StatusResponse> authenticateUser(@RequestBody String loginDTO) throws Exception {
        return authService.authenticate(loginDTO);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<StatusResponse> auth(@RequestParam String sessionId){
        return authService.auth(sessionId);
    }

    @GetMapping("/refreshToken")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<JWTAuthResponse> refreshToken() {
        return authService.refreshToken();
    }

}
