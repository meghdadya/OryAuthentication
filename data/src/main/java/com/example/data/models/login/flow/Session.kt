package com.example.data.models.login.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    @SerialName("active")
    val active: Boolean,
    @SerialName("authenticated_at")
    val authenticatedAt: String,
    @SerialName("expires_at")
    val expiresAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("issued_at")
    val issuedAt: String
)