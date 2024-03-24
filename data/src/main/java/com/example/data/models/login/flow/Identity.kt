package com.example.data.models.login.flow


import com.example.data.models.register.response.flow.Traits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("credentials")
    val credentials: Credentials,
    @SerialName("id")
    val id: String,
    @SerialName("metadata_admin")
    val metadataAdmin: MetadataAdmin,
    @SerialName("organization_id")
    val organizationId: String?=null,
    @SerialName("recovery_addresses")
    val recoveryAddresses: List<RecoveryAddresse>,
    @SerialName("schema_id")
    val schemaId: String,
    @SerialName("schema_url")
    val schemaUrl: String,
    @SerialName("state")
    val state: String,
    @SerialName("state_changed_at")
    val stateChangedAt: String,
    @SerialName("traits")
    val traits: Traits? = null,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("verifiable_addresses")
    val verifiableAddresses: List<VerifiableAddresse>
)