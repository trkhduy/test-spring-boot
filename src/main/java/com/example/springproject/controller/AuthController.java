package com.example.springproject.controller;

import com.example.springproject.dto.base.ResponseGeneral;
import com.example.springproject.dto.request.AuthenticationRequest;
import com.example.springproject.dto.response.AuthenticationResponse;
import com.example.springproject.service.impl.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseGeneral<AuthenticationResponse> register(
            @Validated @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseGeneral.ofCreated("Create successfully",authenticationService.register(authenticationRequest));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseGeneral<String> logIn(
            @Validated @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseGeneral.ofSuccess("Log in successfully", authenticationService.logIn(authenticationRequest));
    }
}
