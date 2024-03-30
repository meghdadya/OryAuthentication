package com.example.data.models.login


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class LoginRequestModel(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("password")
    val password: String
)