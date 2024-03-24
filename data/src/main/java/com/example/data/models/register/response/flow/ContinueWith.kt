package com.example.data.models.register.response.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinueWith(
    @SerialName("action")
    val action: String,
    @SerialName("ory_session_token")
    val orySessionToken: String
)