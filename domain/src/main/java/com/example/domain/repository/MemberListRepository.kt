package com.example.domain.repository

import com.example.domain.utils.Result
import com.example.domain.model.MemberListEntity
import kotlinx.coroutines.flow.Flow

interface MemberListRepository {
    suspend fun getHouseList(): Flow<Result<List<MemberListEntity>>>
}