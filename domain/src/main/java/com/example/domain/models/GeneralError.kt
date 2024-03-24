package com.example.domain.models

sealed class GeneralError {
    data class ApiError(val message: String?, val code: Int) : GeneralError()
    object NetworkError : GeneralError()
    data class UnknownError(val error: Throwable) : GeneralError()
}
