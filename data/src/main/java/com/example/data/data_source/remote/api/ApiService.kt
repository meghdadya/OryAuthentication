package com.example.data.data_source.remote.api

import com.example.data.data_source.remote.network.adapter.NetworkResponse
import com.example.data.models.base.ErrorResponse
import com.example.data.models.login.LoginRequestModel
import com.example.data.models.login.LoginResponseModel
import com.example.data.models.login.flow.LoginFlowResponseModel
import com.example.data.models.register.request.RegisterRequestModel
import com.example.data.models.register.response.RegisterResponseModel
import com.example.data.models.register.response.flow.RegisterFlowResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("self-service/login/api")
    suspend fun fetchLogin(): NetworkResponse<LoginResponseModel, ErrorResponse>


    @POST("self-service/login")
    suspend fun login(
        @Query("flow") flow: String, @Body body: LoginRequestModel
    ): NetworkResponse<LoginFlowResponseModel, ErrorResponse>


    @GET("self-service/registration/api")
    suspend fun fetchRegistration(): NetworkResponse<RegisterResponseModel, ErrorResponse>


    @POST("self-service/registration")
    suspend fun register(
        @Query("flow") flow: String, @Body body: RegisterRequestModel
    ): NetworkResponse<RegisterFlowResponseModel, ErrorResponse>
}