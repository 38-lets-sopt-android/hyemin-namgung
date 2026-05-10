package com.example.letssopt.data.remote.service

import com.example.letssopt.core.network.BaseResponse
import com.example.letssopt.data.model.SignInRequestModel
import com.example.letssopt.data.model.SignInResponseModel
import com.example.letssopt.data.model.SignUpRequestModel
import com.example.letssopt.data.remote.dto.request.SignUpRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignUpService {
    @POST("api/v1/auth/signup")
    suspend fun postSignUp(@Body request : SignUpRequestDto): BaseResponse<Unit>
}
