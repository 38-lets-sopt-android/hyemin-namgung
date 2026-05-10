package com.example.letssopt.data.model

import com.example.letssopt.data.remote.dto.response.SignInResponseDto

data class SignInResponseModel(
    val userId : Int
)

fun SignInResponseDto.toModel() = SignInResponseModel(
    userId = userId
)
