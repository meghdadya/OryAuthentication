package com.example.data.models.register.response


import com.google.gson.annotations.SerializedName



data class Attributes(
    @SerializedName("autocomplete")
    val autocomplete: String? = null,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_type")
    val nodeType: String,
    @SerializedName("required")
    val required: Boolean? = null,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String? = null
)