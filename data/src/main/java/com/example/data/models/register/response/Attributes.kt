package com.example.data.models.register.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attributes(
    @SerialName("autocomplete")
    val autocomplete: String? = null,
    @SerialName("disabled")
    val disabled: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("node_type")
    val nodeType: String,
    @SerialName("required")
    val required: Boolean? = null,
    @SerialName("type")
    val type: String,
    @SerialName("value")
    val value: String? = null
)