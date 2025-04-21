package com.example.domain.usecase

import com.example.domain.utils.Result
import com.example.domain.model.MemberListEntity
import com.example.domain.repository.MemberListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMemberListUseCase @Inject constructor(
    private val memberListRepository: MemberListRepository
) {
    suspend operator fun invoke(): Flow<Result<List<MemberListEntity>>>{
        return memberListRepository.getHouseList()
    }
}