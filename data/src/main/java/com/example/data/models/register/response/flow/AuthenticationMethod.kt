package com.example.data.models.register.response.flow


import com.google.gson.annotations.SerializedName


data class AuthenticationMethod(
    @SerializedName("aal")
    val aal: String,
    @SerializedName("completed_at")
    val completedAt: String,
    @SerializedName("method")
    val method: String
)