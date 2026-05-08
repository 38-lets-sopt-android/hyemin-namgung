package com.example.letssopt.data.repositoryImpl

import com.example.letssopt.data.model.SignInRequestModel
import com.example.letssopt.data.model.SignInResponseModel
import com.example.letssopt.data.model.toDto
import com.example.letssopt.data.model.toModel
import com.example.letssopt.data.remote.datasource.SignInDataSource
import com.example.letssopt.data.repository.SignInRepository

class SignInRepositoryImpl(private val signInDataSource: SignInDataSource) : SignInRepository {
    override suspend fun postSignIn(request: SignInRequestModel): Result<SignInResponseModel> =
        runCatching {
            val response = signInDataSource.postSignIn(request.toDto())

            if (!response.success || response.data == null) {
                throw IllegalStateException(response.message)
            }

            response.data.toModel()
        }
}
