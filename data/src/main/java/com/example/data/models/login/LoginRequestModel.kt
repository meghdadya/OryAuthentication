package com.example.data.models.login


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(
    @SerialName("identifier")
    val identifier: String,
    @SerialName("method")
    val method: String,
    @SerialName("password")
    val password: String
)