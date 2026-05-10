package com.example.letssopt.data.remote

import com.example.letssopt.BuildConfig
import com.example.letssopt.data.remote.service.SignInService
import com.example.letssopt.data.remote.service.SignUpService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient{
    private const val BASE_URL = BuildConfig.BASE_URL

    private val json = Json{ignoreUnknownKeys = true}

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json; charset=UTF-8".toMediaType()))
        .build()

    val signUpService: SignUpService = instance.create(SignUpService::class.java)
    val signInService: SignInService = instance.create(SignInService::class.java)

}
