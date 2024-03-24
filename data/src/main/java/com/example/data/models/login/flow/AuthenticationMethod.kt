package com.example.data.models.login.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationMethod(
    @SerialName("aal")
    val aal: String,
    @SerialName("completed_at")
    val completedAt: String,
    @SerialName("method")
    val method: String,
    @SerialName("organization")
    val organization: String? = null,
    @SerialName("provider")
    val provider: String? = null
)