package com.example.data.models.register.response


import com.example.data.models.base.RemoteResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Node(
    @SerialName("attributes")
    val attributes: Attributes,
    @SerialName("group")
    val group: String,
    @SerialName("messages")
    val messages: List<String?>,
    @SerialName("meta")
    val meta: Meta? = null,
    @SerialName("type")
    val type: String
) : RemoteResponse