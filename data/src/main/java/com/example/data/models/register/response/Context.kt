package com.example.data.models.register.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Context(
    @SerialName("title")
    val title: String
)