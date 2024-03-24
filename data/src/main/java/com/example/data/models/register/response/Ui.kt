package com.example.data.models.register.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ui(
    @SerialName("action")
    val action: String,
    @SerialName("method")
    val method: String,
    @SerialName("nodes")
    val nodes: List<Node>
)