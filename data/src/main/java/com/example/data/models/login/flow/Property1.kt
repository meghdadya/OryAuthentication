package com.example.data.models.login.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Property1(
    @SerialName("config")
    val config: Config,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("identifiers")
    val identifiers: List<String>,
    @SerialName("type")
    val type: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("version")
    val version: Int
)