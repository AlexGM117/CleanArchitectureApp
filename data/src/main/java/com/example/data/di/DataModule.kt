package com.example.data.di

import com.example.data.repository.HoseListRepositoryImpl
import com.example.data.repository.HouseDetailsRepositoryImpl
import com.example.domain.repository.MemberDetailsRepository
import com.example.domain.repository.MemberListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindMemberRepository(houseListRepositoryImpl: HoseListRepositoryImpl): MemberListRepository

    @Binds
    abstract fun bindMemberDetailRepository(houseDetailsRepositoryImpl: HouseDetailsRepositoryImpl): MemberDetailsRepository
}