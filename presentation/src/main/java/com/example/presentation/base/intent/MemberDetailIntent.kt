package com.example.presentation.base.intent

sealed class MemberDetailIntent {
    data object LoadNewsDetails: MemberDetailIntent()
}