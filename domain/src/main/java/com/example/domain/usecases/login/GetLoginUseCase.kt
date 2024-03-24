package com.example.domain.usecases.login

import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.login.LoginDomainModel
import com.example.domain.repositories.login.LoginRepository
import com.example.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(private val loginRepository: LoginRepository) :
    BaseUseCase<Unit, Resource<ListDomainModel<LoginDomainModel>, GeneralError>>() {
    override suspend fun execute(param: Unit): Resource<ListDomainModel<LoginDomainModel>, GeneralError> =
        loginRepository.getLogin()
}