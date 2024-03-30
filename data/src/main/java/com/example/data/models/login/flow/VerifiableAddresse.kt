package com.example.data.models.login.flow


import com.google.gson.annotations.SerializedName

data class VerifiableAddresse(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("value")
    val value: String,
    @SerializedName("verified")
    val verified: Boolean,
    @SerializedName("verified_at")
    val verifiedAt: String,
    @SerializedName("via")
    val via: String
)