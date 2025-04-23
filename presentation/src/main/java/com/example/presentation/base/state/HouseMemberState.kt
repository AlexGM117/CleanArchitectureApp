package com.example.presentation.base.state

sealed interface HouseMemberState<out T> {
    data class Success<T>(val data: T): HouseMemberState<T>
    data class Error(val message: String): HouseMemberState<Nothing>
    object Loading: HouseMemberState<Nothing>
}