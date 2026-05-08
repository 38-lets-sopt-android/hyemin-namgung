package com.example.letssopt.data.remote.datasourceImpl

import com.example.letssopt.core.network.BaseResponse
import com.example.letssopt.data.remote.datasource.SignInDataSource
import com.example.letssopt.data.remote.dto.request.SignInRequestDto
import com.example.letssopt.data.remote.dto.response.SignInResponseDto
import com.example.letssopt.data.remote.service.SignInService


class SignInDataSourceImpl(private val signInService: SignInService) : SignInDataSource{
    override suspend fun postSignIn(
        request: SignInRequestDto
    )  : BaseResponse<SignInResponseDto> = signInService.postSignIn(
            request = request
    )
}
