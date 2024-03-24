package com.example.data.repositories.login

import android.util.Log
import com.example.data.data_source.local.config.ConfigLocalDataSource
import com.example.data.data_source.remote.login.LoginRemoteDataSource
import com.example.data.mappers.login.LoginMapper
import com.example.data.models.login.LoginRequestModel
import com.example.data.utils.DispatcherProvider
import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.login.LoginDomainModel
import com.example.domain.models.login.LoginParamDataModel
import com.example.domain.repositories.login.LoginRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider,
    private val loginMapper: LoginMapper,
    private val configLocalDataSource: ConfigLocalDataSource
) : LoginRepository {
    override suspend fun getLogin(): Resource<ListDomainModel<LoginDomainModel>, GeneralError> {
        return withContext(dispatcherProvider.io) {
            when (val r = loginRemoteDataSource.fetchLogin()) {
                is Resource.Failure -> {
                    Resource.Failure(r.error)
                }

                is Resource.Success -> {
                    configLocalDataSource.updateId(r.data.id)
                    Resource.Success(ListDomainModel(item = r.data.ui.nodes.map {
                        loginMapper.map(
                            it
                        )
                    }))
                }
            }
        }
    }

    override suspend fun login(
        paramDataModel: LoginParamDataModel
    ): Resource<DomainModel, GeneralError> {
        return withContext(dispatcherProvider.io) {
            val request = LoginRequestModel(
                method = "password",
                identifier = paramDataModel.email,
                password = paramDataModel.password,)
            val flow = configLocalDataSource.getId()
            when (val r = loginRemoteDataSource.login(flow, request)) {
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