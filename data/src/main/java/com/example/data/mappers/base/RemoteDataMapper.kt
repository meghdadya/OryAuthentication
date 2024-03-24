package com.example.data.mappers.base

import com.example.data.models.base.RemoteResponse
import com.example.domain.models.DomainModel


 abstract class RemoteDataMapper<R : RemoteResponse, D : DomainModel> {
    abstract fun map(response: R): D
}