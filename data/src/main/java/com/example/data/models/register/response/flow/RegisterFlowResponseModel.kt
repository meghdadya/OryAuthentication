package com.example.data.models.register.response.flow


import com.example.data.models.base.RemoteResponse
import com.google.gson.annotations.SerializedName



data class RegisterFlowResponseModel(
    @SerializedName("continue_with")
    val continueWith: List<ContinueWith>,
    @SerializedName("identity")
    val identity: Identity,
    @SerializedName("session")
    val session: Session,
    @SerializedName("session_token")
    val sessionToken: String
) : RemoteResponse