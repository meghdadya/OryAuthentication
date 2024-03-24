package com.example.data.models.login.flow


import com.example.data.models.base.RemoteResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginFlowResponseModel(
    @SerialName("session")
    val session: Session,
    @SerialName("session_token")
    val sessionToken: String
) : RemoteResponse