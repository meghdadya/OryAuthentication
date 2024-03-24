package com.example.data.models.register.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestModel(
    @SerialName("csrf_token")
    val csrfToken: String,
    @SerialName("method")
    val method: String,
    @SerialName("password")
    val password: String,
    @SerialName("traits")
    val traits: Traits,
    @SerialName("transient_payload")
    val transientPayload: TransientPayload?
)