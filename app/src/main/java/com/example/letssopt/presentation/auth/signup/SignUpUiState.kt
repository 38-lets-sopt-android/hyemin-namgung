package com.example.letssopt.presentation.auth.signup

data class SignUpUiState(
    val email : String = "",
    val password : String = "",
    val confirmPassword : String = ""
){
    val isButtonEnabled : Boolean
        get() = email.isNotBlank() &&
                password.isNotBlank() &&
                confirmPassword.isNotBlank()
}
