package com.example.data.models.login


import com.example.data.models.register.response.Ui
import com.google.gson.annotations.SerializedName


data class LoginResponseModel(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("issued_at")
    val issuedAt: String,
    @SerializedName("organization_id")
    val organizationId: String?=null,
    @SerializedName("refresh")
    val refresh: Boolean,
    @SerializedName("request_url")
    val requestUrl: String,
    @SerializedName("requested_aal")
    val requestedAal: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("ui")
    val ui: Ui,
    @SerializedName("updated_at")
    val updatedAt: String
)