package com.example.data.repository

import com.example.data.api.HouseListApiService
import com.example.data.di.IODispatcher
import com.example.data.mappers.DataMapper
import com.example.domain.model.MemberDetailsEntity
import com.example.domain.repository.MemberDetailsRepository
import com.example.domain.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HouseDetailsRepositoryImpl @Inject constructor(
    private val houseListApiService: HouseListApiService,
    private val dataMapper: DataMapper,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : MemberDetailsRepository {
    override suspend fun getHouseDetails(slug: String): Flow<Result<List<MemberDetailsEntity>>> =
        safeApiCall(
            apiCall = { houseListApiService.getHouseMemberDetails(slug) },
            mapper = { response ->
                dataMapper.mapHouseMemberDetails(response)
            }
        ).flowOn(ioDispatcher)
            .catch { exc ->
                emit(Result.Error("Unexpected error: ${(exc.message)}"))
            }
}