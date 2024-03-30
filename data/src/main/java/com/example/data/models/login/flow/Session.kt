package com.example.data.models.login.flow


import com.google.gson.annotations.SerializedName



data class Session(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("authenticated_at")
    val authenticatedAt: String,
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("issued_at")
    val issuedAt: String
)