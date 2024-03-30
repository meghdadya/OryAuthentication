package com.example.data.models.register.response

import com.example.data.models.base.RemoteResponse
import com.google.gson.annotations.SerializedName


data class Node(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("group")
    val group: String,
    @SerializedName("messages")
    val messages: List<String?>,
    @SerializedName("meta")
    val meta: Meta? = null,
    @SerializedName("type")
    val type: String
) : RemoteResponse