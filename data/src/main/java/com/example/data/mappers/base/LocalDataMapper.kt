package com.example.data.mappers.base

import com.example.data.models.base.LocalDataModel
import com.example.domain.models.DomainModel


 abstract class LocalDataMapper<L : LocalDataModel, D : DomainModel> {
    abstract fun mapTo(local: L): D
    abstract fun mapFrom(domain: D): L
}