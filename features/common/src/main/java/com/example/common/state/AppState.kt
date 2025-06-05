package com.example.common.state

sealed interface AppState<out T> {
    data class Success<T>(val data: T): AppState<T>
    data class Error(val message: String): AppState<Nothing>
    object Loading: AppState<Nothing>
}