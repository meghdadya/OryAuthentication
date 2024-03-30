package com.example.data.repositories.register

import android.util.Log
import com.example.data.data_source.local.config.ConfigLocalDataSource
import com.example.data.data_source.remote.register.RegisterRemoteDataSource
import com.example.data.mappers.register.RegisterMapper
import com.example.data.models.register.request.RegisterRequestModel
import com.example.data.utils.DispatcherProvider
import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterParamDataModel
import com.example.domain.repositories.register.RegisterRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val registerRemoteDataSource: RegisterRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider,
    private val registerMapper: RegisterMapper,
    private val configLocalDataSource: ConfigLocalDataSource
) : RegisterRepository {
    override suspend fun getRegister(): Resource<ListDomainModel<RegisterDomainModel>, GeneralError> {
        return withContext(dispatcherProvider.io) {
            when (val r = registerRemoteDataSource.fetchRegistration()) {
                is Resource.Failure -> {
                    Resource.Failure(r.error)
                }

                is Resource.Success -> {
                    configLocalDataSource.updateId(r.data.id)
                    Resource.Success(ListDomainModel(item = r.data.ui.nodes.map {
                        registerMapper.map(
                            it
                        )
                    }))
                }
            }
        }
    }

    private fun groupByPrefix(map: Map<String, Any>): Map<String, Map<String, Any>> {
        val groupedMap = mutableMapOf<String, MutableMap<String, Any>>()

        for ((key, value) in map) {
            val trimmedKey = key.removePrefix("traits.")
            val prefix = trimmedKey.substringBefore('.')
            val innerKey = trimmedKey.substringAfter('.', "")
            if (innerKey.isNotEmpty()) {
                val innerMap = groupedMap.getOrPut(prefix) { mutableMapOf() }
                innerMap[innerKey] = value
            } else {
                // If innerKey is empty, skip adding to inner map
                val existingMap = groupedMap[prefix]
                if (existingMap == null) {
                    groupedMap[prefix] = mutableMapOf(trimmedKey to value)
                } else {
                    existingMap[key] = value
                }
            }
        }

        return groupedMap
    }

    private fun flattenMap(groupedMap: Map<String, Map<String, Any>>): Map<String, Any> {
        val flattenedMap = mutableMapOf<String, Any>()
        for ((_, innerMap) in groupedMap) {
            flattenedMap.putAll(innerMap)
        }
        return flattenedMap
    }

    private fun filterGroupsBySize(
        groupedMap: Map<String, Map<String, Any>>,
        range: IntRange
    ): Map<String, Map<String, Any>> {
        return groupedMap.filter { it.value.size in range }
    }

    override suspend fun register(
        paramDataModel: RegisterParamDataModel
    ): Resource<DomainModel, GeneralError> {
        return withContext(dispatcherProvider.io) {
            val password = paramDataModel.params["password"] ?: ""
            val traits = paramDataModel.params.filter { it.key != "password" }
                .filter { it.key != "password" }.filter { it.key!="csrf_token" }.filter { it.key!="method" }

            val groupedMap = groupByPrefix(traits)


            val singleValueGroups = flattenMap(filterGroupsBySize(groupedMap, 1..2))
            val multipleValueGroups = filterGroupsBySize(groupedMap, 2..Int.MAX_VALUE)
            val result = singleValueGroups + multipleValueGroups

            val request = RegisterRequestModel(
                csrfToken = "",
                method = "password",
                traits = result,
                password = password as String,
                transientPayload = null

            )
            val flow = configLocalDataSource.getId()
            when (val r = registerRemoteDataSource.register(flow, request)) {
                is Resource.Failure -> {
                    Resource.Failure(r.error)
                }

                is Resource.Success -> {
                    Log.d("Test Repository", r.data.toString())
                    Resource.Success(object : DomainModel {})
                }
            }
        }
    }
}