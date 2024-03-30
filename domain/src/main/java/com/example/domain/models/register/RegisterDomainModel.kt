package com.example.domain.models.register

import com.example.domain.models.DomainModel

data class RegisterDomainModel(
    val disabled: Boolean,val name:String, val label: String, val required: Boolean, val type: RegisterFiledType?
) : DomainModel


enum class RegisterFiledType(val typeName: String) {
    EMAIL(typeName = "email"), PASSWORD(typeName = "password"), TEXT(
        typeName = "text"
    ),
    NUMBER("number"), CHECKBOX("checkbox"), TEL("tel")
}