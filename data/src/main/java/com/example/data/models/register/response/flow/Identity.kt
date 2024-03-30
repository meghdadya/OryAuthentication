package com.example.data.models.register.response.flow


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class Identity(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("organization_id")
    val organizationId: String?,
    @SerializedName("schema_id")
    val schemaId: String,
    @SerializedName("schema_url")
    val schemaUrl: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("state_changed_at")
    val stateChangedAt: String,
    @SerializedName("traits")
    val traits: Traits,
    @SerializedName("updated_at")
    val updatedAt: String
)