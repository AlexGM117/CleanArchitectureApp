package com.example.data.repository

import com.example.data.api.HouseListApiService
import com.example.data.di.IODispatcher
import com.example.data.mappers.DataMapper
import com.example.domain.model.MemberListEntity
import com.example.domain.repository.MemberListRepository
import com.example.domain.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HoseListRepositoryImpl @Inject constructor(
    private val houseListApiService: HouseListApiService,
    private val dataMapper: DataMapper,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
): MemberListRepository {
    override suspend fun getHouseList(): Flow<Result<List<MemberListEntity>>> =
        safeApiCall(
            apiCall = { houseListApiService.getHouseMemberList() },
            mapper = { response ->
                dataMapper.mapHouseMemberList(response)
            }
        ).flowOn(ioDispatcher)

}