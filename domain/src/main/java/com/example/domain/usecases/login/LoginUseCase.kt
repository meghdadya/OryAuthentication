package com.example.domain.usecases.login

import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource
import com.example.domain.models.login.LoginParamDataModel
import com.example.domain.repositories.login.LoginRepository
import com.example.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) :
    BaseUseCase<LoginParamDataModel, Resource<DomainModel, GeneralError>>() {
    override suspend fun execute(param: LoginParamDataModel): Resource<DomainModel, GeneralError> =
        loginRepository.login(param)
}