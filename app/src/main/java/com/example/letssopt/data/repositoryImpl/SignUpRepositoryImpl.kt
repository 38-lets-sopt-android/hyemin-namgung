package com.example.letssopt.data.repositoryImpl

import com.example.letssopt.data.model.SignUpRequestModel
import com.example.letssopt.data.model.toDto
import com.example.letssopt.data.remote.datasource.SignUpDataSource
import com.example.letssopt.data.repository.SignUpRepository

class SignUpRepositoryImpl(
    private val signUpDataSource: SignUpDataSource
) : SignUpRepository {

    override suspend fun postSignUp(request: SignUpRequestModel): Result<Unit> =
        runCatching {
            val response = signUpDataSource.postSignUp(request.toDto())

            if (!response.success) {
                throw IllegalStateException(response.message)
            }

            Unit
        }
}
