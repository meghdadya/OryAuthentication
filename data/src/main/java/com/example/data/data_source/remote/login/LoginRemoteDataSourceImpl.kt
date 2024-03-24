package com.example.data.data_source.remote.login

import com.example.data.data_source.remote.api.ApiService
import com.example.data.data_source.remote.network.adapter.NetworkResponse
import com.example.data.models.login.LoginRequestModel
import com.example.data.models.login.LoginResponseModel
import com.example.data.models.login.flow.LoginFlowResponseModel
import com.example.data.models.register.request.RegisterRequestModel
import com.example.data.models.register.response.RegisterResponseModel
import com.example.data.models.register.response.flow.RegisterFlowResponseModel

import com.example.domain.models.GeneralError
import com.example.domain.models.Resource
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    LoginRemoteDataSource {

    override suspend fun fetchLogin(): Resource<LoginResponseModel, GeneralError> {
        return when (val result = apiService.fetchLogin()) {
            is NetworkResponse.ApiError -> {
                val errorResponse = result.body

                Resource.Failure(
                    GeneralError.ApiError(
                        errorResponse.statusMessage,
                        errorResponse.statusCode
                    )
                )
            }

            is NetworkResponse.NetworkError -> {
                Resource.Failure(GeneralError.NetworkError)
            }

            is NetworkResponse.Success -> {
                val userResponse = result.body
                if (userResponse == null) {
                    Resource.Failure(GeneralError.UnknownError(Throwable("User Response is null")))
                } else {
                    Resource.Success(userResponse)
                }
            }

            is NetworkResponse.UnknownError -> Resource.Failure(GeneralError.UnknownError(result.error))
        }
    }

    override suspend fun login(
        flow: String,
        loginModel: LoginRequestModel
    ): Resource<LoginFlowResponseModel, GeneralError> {
        return when (val result = apiService.login(flow, loginModel)) {
            is NetworkResponse.ApiError -> {
                val errorResponse = result.body

                Resource.Failure(
                    GeneralError.ApiError(
                        errorResponse.statusMessage,
                        errorResponse.statusCode
                    )
                )
            }

            is NetworkResponse.NetworkError -> {
                Resource.Failure(GeneralError.NetworkError)
            }

            is NetworkResponse.Success -> {
                val userResponse = result.body
                if (userResponse == null) {
                    Resource.Failure(GeneralError.UnknownError(Throwable("User Response is null")))
                } else {
                    Resource.Success(userResponse)
                }
            }

            is NetworkResponse.UnknownError -> Resource.Failure(GeneralError.UnknownError(result.error))
        }
    }
}