package com.example.data.mappers.login

import com.example.data.mappers.base.RemoteDataMapper
import com.example.data.models.register.response.Node
import com.example.domain.models.login.LoginDomainModel
import com.example.domain.models.login.LoginFiledType
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterFiledType
import javax.inject.Inject

class LoginMapper @Inject constructor() : RemoteDataMapper<Node, LoginDomainModel>() {
    override fun map(response: Node): LoginDomainModel {
        return with(response) {
            LoginDomainModel(
                disabled = response.attributes.disabled,
                label = response.meta?.label?.text ?: "",
                required = response.attributes.required ?: false,
                type = LoginFiledType.entries.single { response.attributes.type == it.typeName }
            )
        }
    }
}