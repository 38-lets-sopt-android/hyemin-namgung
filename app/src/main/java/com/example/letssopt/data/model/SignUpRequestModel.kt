package com.example.letssopt.data.model

import com.example.letssopt.data.remote.dto.request.SignInRequestDto
import com.example.letssopt.data.remote.dto.request.SignUpRequestDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class SignUpRequestModel(
    val loginId : String,
    val password : String,
    val name : String,
    val email : String,
    val age : Int,
    val part : String
)

fun SignUpRequestModel.toDto() = SignUpRequestDto(
    loginId = loginId,
    password = password,
    name = name,
    email = email,
    age = age,
    part = part
)
