package com.example.presentation.base.intent

sealed class MemberIntent {
    data object LoadHouseMember: MemberIntent()
    data class onListSelected(val id: String): MemberIntent()
}