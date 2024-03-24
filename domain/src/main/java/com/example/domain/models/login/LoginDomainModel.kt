package com.example.domain.models.login

import com.example.domain.models.DomainModel

data class LoginDomainModel(
    val disabled: Boolean, val label: String, val required: Boolean, val type: LoginFiledType
) : DomainModel


enum class LoginFiledType(val typeName: String) {
    HIDDEN(typeName = "hidden"), EMAIL(typeName = "email"), PASSWORD(typeName = "password"), TEXT(
        typeName = "text"
    ),
    SUBMIT(typeName = "submit"),
}