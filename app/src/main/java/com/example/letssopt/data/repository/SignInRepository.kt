package com.example.letssopt.data.repository

import com.example.letssopt.data.model.SignInRequestModel
import com.example.letssopt.data.model.SignInResponseModel

interface SignInRepository{
    suspend fun postSignIn(request : SignInRequestModel):
            Result<SignInResponseModel>
}
