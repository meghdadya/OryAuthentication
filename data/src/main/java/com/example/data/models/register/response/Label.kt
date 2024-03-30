package com.example.data.models.register.response

import com.google.gson.annotations.SerializedName


data class Label(
    @SerializedName("context")
    val context: Context?=null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)