package com.example.letssopt.data.remote.datasource

import com.example.letssopt.core.network.BaseResponse
import com.example.letssopt.data.remote.dto.request.SignInRequestDto
import com.example.letssopt.data.remote.dto.response.SignInResponseDto

interface SignInDataSource{
    suspend fun postSignIn(
        request : SignInRequestDto
    ): BaseResponse<SignInResponseDto>
}
