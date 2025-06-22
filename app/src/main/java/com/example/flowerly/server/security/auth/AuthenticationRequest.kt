package com.example.flowerly.server.security.auth

data class AuthenticationRequest(
    val email: String,
    val password: String
)