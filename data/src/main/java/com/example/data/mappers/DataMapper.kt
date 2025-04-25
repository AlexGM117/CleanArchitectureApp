package com.example.data.mappers

import com.example.data.models.HouseMembers
import com.example.data.models.MemberDetailsDTO
import com.example.data.models.MemberListDTO
import com.example.domain.model.MemberDetailsEntity
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

    fun mapHouseMemberDetails(memberLDetailResponse: List<MemberDetailsDTO>): List<MemberDetailsEntity>{
        return memberLDetailResponse.map { result ->
            MemberDetailsEntity(
                name = result.name.orEmpty(),
                slug = result.slug.orEmpty(),
                members = getMembers(result.members)
            )
        }
    }

    private fun getMembers(members: ArrayList<HouseMembers>): List<MemberListEntity>{
        return members.map { result ->
            MemberListEntity(
                name = result.name!!,
                slug = result.slug!!
            )
        }
    }
}