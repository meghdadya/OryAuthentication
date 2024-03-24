package com.example.data.data_source.remote.login


import com.example.data.models.login.LoginRequestModel
import com.example.data.models.login.LoginResponseModel
import com.example.data.models.login.flow.LoginFlowResponseModel
import com.example.data.models.register.request.RegisterRequestModel
import com.example.data.models.register.response.RegisterResponseModel
import com.example.data.models.register.response.flow.RegisterFlowResponseModel
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource


interface LoginRemoteDataSource {


    suspend fun fetchLogin(): Resource<LoginResponseModel, GeneralError>

    suspend fun login(
        flow: String,
        loginModel: LoginRequestModel
    ): Resource<LoginFlowResponseModel, GeneralError>

}