package com.example.letssopt.data.remote.service

import com.example.letssopt.core.network.BaseResponse
import com.example.letssopt.data.model.SignInRequestModel
import com.example.letssopt.data.model.SignInResponseModel
import com.example.letssopt.data.model.SignUpRequestModel
import com.example.letssopt.data.remote.dto.request.SignInRequestDto
import com.example.letssopt.data.remote.dto.response.SignInResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {

    @POST("api/v1/auth/signin")
    suspend fun postSignIn(@Body request : SignInRequestDto): BaseResponse<SignInResponseDto>

}
