package com.example.data.models.login


import com.example.data.models.register.response.Ui
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseModel(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("expires_at")
    val expiresAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("issued_at")
    val issuedAt: String,
    @SerialName("organization_id")
    val organizationId: String?=null,
    @SerialName("refresh")
    val refresh: Boolean,
    @SerialName("request_url")
    val requestUrl: String,
    @SerialName("requested_aal")
    val requestedAal: String,
    @SerialName("state")
    val state: String,
    @SerialName("type")
    val type: String,
    @SerialName("ui")
    val ui: Ui,
    @SerialName("updated_at")
    val updatedAt: String
)