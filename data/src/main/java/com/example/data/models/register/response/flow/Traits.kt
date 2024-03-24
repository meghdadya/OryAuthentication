package com.example.data.models.register.response.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Traits(
    @SerialName("email")
    val email: String
)