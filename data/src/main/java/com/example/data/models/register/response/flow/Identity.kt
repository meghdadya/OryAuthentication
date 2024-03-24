package com.example.data.models.register.response.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("organization_id")
    val organizationId: String?,
    @SerialName("schema_id")
    val schemaId: String,
    @SerialName("schema_url")
    val schemaUrl: String,
    @SerialName("state")
    val state: String,
    @SerialName("state_changed_at")
    val stateChangedAt: String,
    @SerialName("traits")
    val traits: Traits,
    @SerialName("updated_at")
    val updatedAt: String
)