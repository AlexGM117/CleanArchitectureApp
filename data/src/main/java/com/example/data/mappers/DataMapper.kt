package com.example.data.mappers

import com.example.data.MemberListDTO
import com.example.domain.model.MemberListEntity
import javax.inject.Inject

class DataMapper @Inject constructor()  {
    fun mapHouseMemberList(memberListResponse: List<MemberListDTO>): List<MemberListEntity>{
        return memberListResponse.map { result ->
            MemberListEntity(
                name = result.name.orEmpty(),
                slug = result.slug.orEmpty()
            )
        }
    }
}