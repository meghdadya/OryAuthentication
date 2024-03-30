package com.example.data.models.login.flow


import com.example.data.models.base.RemoteResponse
import com.google.gson.annotations.SerializedName


data class LoginFlowResponseModel(
    @SerializedName("session_token")
    val sessionToken: String
) : RemoteResponse