package com.example.data.models.login.flow

import com.google.gson.annotations.SerializedName


data class Property1(
    @SerializedName("config")
    val config: Config,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("identifiers")
    val identifiers: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("version")
    val version: Int
)