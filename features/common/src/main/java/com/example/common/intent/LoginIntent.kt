package com.example.presentation.base.intent

sealed class LoginIntent {
    data object LoadLoginData: LoginIntent()
    data object onLongClick: LoginIntent()
}
