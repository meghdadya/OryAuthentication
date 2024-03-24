package com.example.data.models.register.response.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    @SerialName("active")
    val active: Boolean,
    @SerialName("authenticated_at")
    val authenticatedAt: String,
    @SerialName("authentication_methods")
    val authenticationMethods: List<AuthenticationMethod>,
    @SerialName("authenticator_assurance_level")
    val authenticatorAssuranceLevel: String,
    @SerialName("devices")
    val devices: List<Device>,
    @SerialName("expires_at")
    val expiresAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("identity")
    val identity: Identity,
    @SerialName("issued_at")
    val issuedAt: String
)