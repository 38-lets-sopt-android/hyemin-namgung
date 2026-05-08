package com.example.letssopt.data.remote.datasourceImpl

import com.example.letssopt.core.network.BaseResponse
import com.example.letssopt.data.remote.datasource.SignUpDataSource
import com.example.letssopt.data.remote.dto.request.SignUpRequestDto
import com.example.letssopt.data.remote.dto.response.SignInResponseDto
import com.example.letssopt.data.remote.service.SignUpService

class SignUpDataSourceImpl(private val signUpService: SignUpService) : SignUpDataSource {
    override suspend fun postSignUp(request: SignUpRequestDto): BaseResponse<Unit> =
        signUpService.postSignUp(request = request)
}
