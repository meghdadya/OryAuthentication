package com.example.data.models.register.response.flow


import com.example.data.models.base.RemoteResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterFlowResponseModel(
    @SerialName("continue_with")
    val continueWith: List<ContinueWith>,
    @SerialName("identity")
    val identity: Identity,
    @SerialName("session")
    val session: Session,
    @SerialName("session_token")
    val sessionToken: String
) : RemoteResponse