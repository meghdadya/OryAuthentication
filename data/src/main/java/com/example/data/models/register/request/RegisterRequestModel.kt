package com.example.data.models.register.request

import com.google.gson.annotations.SerializedName


data class RegisterRequestModel(
    @SerializedName("csrf_token")
    val csrfToken: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("traits")
    val traits: Map<String, Any>,
    @SerializedName("transient_payload")
    val transientPayload: TransientPayload?
)