package com.example.data.models.register.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Label(
    @SerialName("context")
    val context: Context?=null,
    @SerialName("id")
    val id: Int,
    @SerialName("text")
    val text: String,
    @SerialName("type")
    val type: String
)