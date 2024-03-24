package com.example.data.repositories.register

import android.util.Log
import com.example.data.data_source.local.config.ConfigLocalDataSource
import com.example.data.data_source.remote.register.RegisterRemoteDataSource
import com.example.data.mappers.register.RegisterMapper
import com.example.data.models.register.request.RegisterRequestModel
import com.example.data.models.register.request.Traits
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
                    configLocalDataSource.updateId( r.data.id)
                    Resource.Success(ListDomainModel(item = r.data.ui.nodes.map {
                        registerMapper.map(
                            it
                        )
                    }))
                }
            }
        }
    }

    override suspend fun register(
         paramDataModel: RegisterParamDataModel
    ): Resource<DomainModel, GeneralError> {
        return withContext(dispatcherProvider.io) {
            val request = RegisterRequestModel(
                csrfToken = "",
                method = "password",
                traits = Traits(email = paramDataModel.email, fullName = paramDataModel.fullName),
                password = paramDataModel.password,
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