package com.example.data.mappers.register

import com.example.data.mappers.base.RemoteDataMapper
import com.example.data.models.register.response.Node
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterFiledType
import javax.inject.Inject

class RegisterMapper @Inject constructor() : RemoteDataMapper<Node, RegisterDomainModel>() {
    override fun map(response: Node): RegisterDomainModel {
        return with(response) {
            RegisterDomainModel(
                disabled = response.attributes.disabled,
                label = response.meta?.label?.text ?: "",
                required = response.attributes.required ?: false,
                type = RegisterFiledType.entries.single { response.attributes.type == it.typeName }
            )
        }
    }
}