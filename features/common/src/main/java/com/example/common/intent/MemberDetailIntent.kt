package com.example.common.intent

sealed class MemberDetailIntent {
    data object LoadNewsDetails: MemberDetailIntent()
}