package com.example.letssopt.data.repository

import com.example.letssopt.data.model.SignUpRequestModel

interface SignUpRepository {
    suspend fun postSignUp(request: SignUpRequestModel): Result<Unit>
}
