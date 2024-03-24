package com.example.domain.usecases.base


import com.example.domain.models.DomainModel
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource


abstract class BaseUseCase<Param, out R : Resource<DomainModel, GeneralError>> {
    abstract suspend fun execute(param: Param): R
}