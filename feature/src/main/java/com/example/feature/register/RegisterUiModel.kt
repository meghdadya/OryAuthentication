package com.example.feature.register

class RegisterUiModel(
    val name:String,var label: String, val value: ValueType?
)

sealed class ValueType {
    data class IntValue(var value: String?) : ValueType()
    data class BooleanValue(var value: Boolean) : ValueType()
    data class StringValue(var value: String?) : ValueType()
}