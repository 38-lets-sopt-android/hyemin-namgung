package com.example.letssopt.presentation.auth.signup

data class SignUpUiState(
    val loginId: String = "",

    val password: String = "",
    val confirmPassword: String = "",

    val name: String = "",

    val email: String = "",
    val age: String = " ",
    val part: String = " "
) {

    val isPasswordSame : Boolean
        get() = password == confirmPassword
    val isButtonEnabled: Boolean
        get() = listOf(
            loginId,
            password,
            confirmPassword,
            name,
            email,
            age,
            part).all { it.isNotBlank() } && isPasswordSame

}

enum class Part(val string: String) {
    ANDROID("안드로이드"),
    IOS("iOS"),
    WEB("웹"),
}
