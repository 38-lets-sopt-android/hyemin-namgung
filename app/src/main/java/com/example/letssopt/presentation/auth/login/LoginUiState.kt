package com.example.letssopt.presentation.auth.login

data class LoginUiState(
    val email : String = "",
    val password : String = "",
    val isLoading : Boolean = false,
    val errorMessage : String? = null
){
    val isLoginButtonEnabled: Boolean
        get() = email.isNotBlank() && password.length in 8..12
}
