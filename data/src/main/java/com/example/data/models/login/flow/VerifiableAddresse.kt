package com.example.data.models.login.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifiableAddresse(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("status")
    val status: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("value")
    val value: String,
    @SerialName("verified")
    val verified: Boolean,
    @SerialName("verified_at")
    val verifiedAt: String,
    @SerialName("via")
    val via: String
)