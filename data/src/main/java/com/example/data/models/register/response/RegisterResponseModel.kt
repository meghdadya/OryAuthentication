package com.example.data.models.register.response


import com.example.data.models.base.RemoteResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponseModel(
    @SerialName("expires_at")
    val expiresAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("issued_at")
    val issuedAt: String,
    @SerialName("organization_id")
    val organizationId: String?,
    @SerialName("request_url")
    val requestUrl: String,
    @SerialName("state")
    val state: String,
    @SerialName("type")
    val type: String,
    @SerialName("ui")
    val ui: Ui
) : RemoteResponse