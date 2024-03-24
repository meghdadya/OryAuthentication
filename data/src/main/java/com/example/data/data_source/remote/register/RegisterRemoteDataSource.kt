package com.example.data.data_source.remote.register


import com.example.data.models.register.request.RegisterRequestModel
import com.example.data.models.register.response.RegisterResponseModel
import com.example.data.models.register.response.flow.RegisterFlowResponseModel
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource


interface RegisterRemoteDataSource {


    suspend fun fetchRegistration(): Resource<RegisterResponseModel, GeneralError>

    suspend fun register(
        flow: String,
        registerModel: RegisterRequestModel
    ): Resource<RegisterFlowResponseModel, GeneralError>

}