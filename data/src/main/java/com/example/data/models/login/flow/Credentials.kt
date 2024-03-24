package com.example.data.models.login.flow


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    @SerialName("property1")
    val property1: Property1,
    @SerialName("property2")
    val property2: Property1
)