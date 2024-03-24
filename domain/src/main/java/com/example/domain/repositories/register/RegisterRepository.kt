package com.example.domain.repositories.register

import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterParamDataModel
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {

    suspend fun getRegister(): Resource<ListDomainModel<RegisterDomainModel>, GeneralError>

    suspend fun register(
        paramDataModel: RegisterParamDataModel
    ): Resource<DomainModel, GeneralError>

}