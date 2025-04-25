package com.example.domain.usecase

import com.example.domain.model.MemberDetailsEntity
import com.example.domain.repository.MemberDetailsRepository
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMemberDetailUseCase @Inject constructor(
    private val memberDetailsRepository: MemberDetailsRepository
) {
    suspend operator fun invoke(slug: String): Flow<Result<List<MemberDetailsEntity>>>{
        return memberDetailsRepository.getHouseDetails(slug)
    }
}