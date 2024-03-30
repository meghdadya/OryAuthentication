package com.example.data.models.login.flow


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class AuthenticationMethod(
    @SerializedName("aal")
    val aal: String,
    @SerializedName("completed_at")
    val completedAt: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("organization")
    val organization: String? = null,
    @SerializedName("provider")
    val provider: String? = null
)