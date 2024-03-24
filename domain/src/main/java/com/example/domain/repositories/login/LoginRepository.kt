package com.example.domain.repositories.login

import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.login.LoginDomainModel
import com.example.domain.models.login.LoginParamDataModel

interface LoginRepository {

    suspend fun getLogin(): Resource<ListDomainModel<LoginDomainModel>, GeneralError>

    suspend fun login(
        paramDataModel: LoginParamDataModel
    ): Resource<DomainModel, GeneralError>

}