package com.example.data.data_source.local.config


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject


class ConfigLocalDataSourceImpl @Inject constructor(
    private val dataSource: DataStore<Preferences>
) :
    ConfigLocalDataSource {
    override suspend fun getId(): String {
        return dataSource.data.first()[idKey] ?: ""
    }

    override suspend fun updateId(id: String) {
        dataSource.edit { preferences ->
            preferences[idKey] = id
        }

    }

    private val idKey = stringPreferencesKey("id")
}