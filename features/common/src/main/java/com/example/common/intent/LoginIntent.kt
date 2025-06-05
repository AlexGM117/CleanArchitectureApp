package com.example.common.intent

sealed class LoginIntent {
    data object LoadLoginData: LoginIntent()
    data object onLongClick: LoginIntent()
}
