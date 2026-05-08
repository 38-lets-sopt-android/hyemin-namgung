package com.example.letssopt.presentation.auth.login

data class LoginUiState(
    val loginId : String = "",
    val password : String = "",
    val isLoading : Boolean = false,
    val errorMessage : String? = null
){
    val isLoginButtonEnabled: Boolean
        get() = loginId.isNotBlank() && password.length in 8..12
}
