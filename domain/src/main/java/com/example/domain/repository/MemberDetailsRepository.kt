package com.example.domain.repository

import com.example.domain.model.MemberDetailsEntity
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface MemberDetailsRepository {
    suspend fun getHouseDetails(slug: String): Flow<Result<List<MemberDetailsEntity>>>
}