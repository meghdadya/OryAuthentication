package com.example.domain.models

sealed class Resource<out S, out E> {
  data class Success<out S>(val data: S) : Resource<S, Nothing>()
  data class Failure<out E>(val error: E) : Resource<Nothing, E>()
}
