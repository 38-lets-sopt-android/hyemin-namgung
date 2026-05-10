package com.example.letssopt.data.model

import com.example.letssopt.data.remote.dto.request.SignInRequestDto

data class SignInRequestModel(
    val loginId: String,
    val password: String
)

fun SignInRequestModel.toDto() = SignInRequestDto(
    loginId = loginId,
    password = password
)
