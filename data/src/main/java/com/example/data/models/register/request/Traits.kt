package com.example.data.models.register.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Traits(
    @SerialName("email") val email: String,
    @SerialName("full_name") val fullName: String
)