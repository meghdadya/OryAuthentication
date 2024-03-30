package com.example.data.models.register.response.flow

import com.google.gson.annotations.SerializedName


data class Device(
    @SerializedName("id")
    val id: String,
    @SerializedName("ip_address")
    val ipAddress: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("user_agent")
    val userAgent: String
)