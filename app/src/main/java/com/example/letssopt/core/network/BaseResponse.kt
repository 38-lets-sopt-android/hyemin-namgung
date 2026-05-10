package com.example.letssopt.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("success")
    val success: Boolean,

    @SerialName("status")
    val status: Int,

    @SerialName("message")
    val message: String,

    @SerialName("code")
    val code: String,

    @SerialName("data")
    val data: T? = null,

    @SerialName("meta")
    val meta: MetaResponse? = null

)

@Serializable
data class MetaResponse(
    @SerialName("path")
    val path: String,

    @SerialName("timestamp")
    val timestamp: String
)
