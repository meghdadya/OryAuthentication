package com.example.domain.usecases.register

import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.repositories.register.RegisterRepository
import com.example.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class GetRegisterUseCase @Inject constructor(private val registerRepository: RegisterRepository) :
    BaseUseCase<Unit, Resource<ListDomainModel<RegisterDomainModel>, GeneralError>>() {
    override suspend fun execute(param: Unit): Resource<ListDomainModel<RegisterDomainModel>, GeneralError> =
        registerRepository.getRegister()
}