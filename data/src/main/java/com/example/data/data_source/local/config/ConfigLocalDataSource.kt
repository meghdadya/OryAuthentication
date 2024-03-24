package com.example.data.data_source.local.config



interface ConfigLocalDataSource {

    suspend fun getId(): String


    suspend fun updateId(id: String)

}