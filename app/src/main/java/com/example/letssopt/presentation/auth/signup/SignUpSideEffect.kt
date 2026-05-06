package com.example.letssopt.presentation.auth.signup

sealed interface SignUpSideEffect{

    data class ShowSnackbar (
        val message : String
    ) : SignUpSideEffect

    data object SignUpSuccess: SignUpSideEffect

}
