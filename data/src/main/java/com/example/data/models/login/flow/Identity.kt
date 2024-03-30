package com.example.data.models.login.flow


import com.example.data.models.register.response.flow.Traits
import com.google.gson.annotations.SerializedName


data class Identity(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("credentials")
    val credentials: Credentials,
    @SerializedName("id")
    val id: String,
    @SerializedName("metadata_admin")
    val metadataAdmin: MetadataAdmin,
    @SerializedName("organization_id")
    val organizationId: String?=null,
    @SerializedName("recovery_addresses")
    val recoveryAddresses: List<RecoveryAddresse>,
    @SerializedName("schema_id")
    val schemaId: String,
    @SerializedName("schema_url")
    val schemaUrl: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("state_changed_at")
    val stateChangedAt: String,
    @SerializedName("traits")
    val traits: Traits? = null,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("verifiable_addresses")
    val verifiableAddresses: List<VerifiableAddresse>
)