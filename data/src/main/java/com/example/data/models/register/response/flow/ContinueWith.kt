package com.example.data.models.register.response.flow


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class ContinueWith(
    @SerializedName("action")
    val action: String,
    @SerializedName("ory_session_token")
    val orySessionToken: String
)