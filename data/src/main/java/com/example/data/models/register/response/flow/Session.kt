package com.example.data.models.register.response.flow

import com.google.gson.annotations.SerializedName


data class Session(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("authenticated_at")
    val authenticatedAt: String,
    @SerializedName("authentication_methods")
    val authenticationMethods: List<AuthenticationMethod>,
    @SerializedName("authenticator_assurance_level")
    val authenticatorAssuranceLevel: String,
    @SerializedName("devices")
    val devices: List<Device>,
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("identity")
    val identity: Identity,
    @SerializedName("issued_at")
    val issuedAt: String
)