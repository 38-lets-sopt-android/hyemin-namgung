package com.example.letssopt.presentation.auth.login

sealed interface LoginSideEffect{
    data object LoginSuccess : LoginSideEffect
    data class ShowToastMessage(val message : String) : LoginSideEffect
}
