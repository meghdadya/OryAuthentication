package com.example.data.models.register.response.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Device(
    @SerialName("id")
    val id: String,
    @SerialName("ip_address")
    val ipAddress: String,
    @SerialName("location")
    val location: String,
    @SerialName("user_agent")
    val userAgent: String
)