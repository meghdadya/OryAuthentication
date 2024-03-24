package com.example.domain.usecases.register

import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.ListDomainModel
import com.example.domain.models.Resource
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterParamDataModel
import com.example.domain.repositories.register.RegisterRepository
import com.example.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val registerRepository: RegisterRepository) :
    BaseUseCase<RegisterParamDataModel, Resource<DomainModel, GeneralError>>() {
    override suspend fun execute(param: RegisterParamDataModel): Resource<DomainModel, GeneralError> =
        registerRepository.register(param)
}