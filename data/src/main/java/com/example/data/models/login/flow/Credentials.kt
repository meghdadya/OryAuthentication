package com.example.data.models.login.flow


import com.google.gson.annotations.SerializedName


data class Credentials(
    @SerializedName("property1")
    val property1: Property1,
    @SerializedName("property2")
    val property2: Property1
)