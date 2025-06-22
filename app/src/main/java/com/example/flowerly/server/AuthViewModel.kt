package com.example.flowerly.server

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowerly.server.security.auth.AuthenticationRequest
import com.example.flowerly.server.security.auth.AuthenticationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _authResult = MutableStateFlow<AuthResult?>(null)
    val authResult: StateFlow<AuthResult?> = _authResult

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    sealed class AuthResult {
        data class Success(val response: AuthenticationResponse) : AuthResult()
        data class Error(val message: String) : AuthResult()
    }

    fun authenticate(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitClient.authApiService.authenticate(
                    AuthenticationRequest(email, password)
                )

                if (response.accessToken.isNullOrEmpty()) {
                    _authResult.value = AuthResult.Error("Authentication failed: empty token")
                } else {
                    _authResult.value = AuthResult.Success(response)
                }
            } catch (e: Exception) {
                Log.e("AUTH", "Error: ${e.message}", e)
                _authResult.value = AuthResult.Error(
                    e.message ?: "Authentication failed"
                )
            } finally {
                _isLoading.value = false
            }
        }
    }
}