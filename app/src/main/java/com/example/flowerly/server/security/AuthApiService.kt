package com.example.flowerly.server.security

import com.example.flowerly.server.security.auth.AuthenticationRequest
import com.example.flowerly.server.security.auth.AuthenticationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/api/v1/auth/authenticate")
    suspend fun authenticate(
        @Body request: AuthenticationRequest
    ): AuthenticationResponse

}