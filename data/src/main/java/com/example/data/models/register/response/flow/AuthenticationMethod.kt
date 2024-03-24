package com.example.data.models.register.response.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationMethod(
    @SerialName("aal")
    val aal: String,
    @SerialName("completed_at")
    val completedAt: String,
    @SerialName("method")
    val method: String
)