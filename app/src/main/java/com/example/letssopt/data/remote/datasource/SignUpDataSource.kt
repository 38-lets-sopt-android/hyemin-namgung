package com.example.letssopt.data.remote.datasource

import com.example.letssopt.core.network.BaseResponse
import com.example.letssopt.data.remote.dto.request.SignInRequestDto
import com.example.letssopt.data.remote.dto.request.SignUpRequestDto
import com.example.letssopt.data.remote.dto.response.SignInResponseDto

interface SignUpDataSource{
    suspend fun postSignUp(
        request : SignUpRequestDto
    ) : BaseResponse<Unit>
}
