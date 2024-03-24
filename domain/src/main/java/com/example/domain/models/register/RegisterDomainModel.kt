package com.example.domain.models.register

import com.example.domain.models.DomainModel

data class RegisterDomainModel(
    val disabled: Boolean, val label: String, val required: Boolean, val type: RegisterFiledType
) : DomainModel


enum class RegisterFiledType(val typeName: String) {
    HIDDEN(typeName = "hidden"), EMAIL(typeName = "email"), PASSWORD(typeName = "password"), TEXT(
        typeName = "text"
    ),
    SUBMIT(typeName = "submit")
}