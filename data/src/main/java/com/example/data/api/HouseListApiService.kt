package com.example.data.api

import com.example.data.models.MemberListDTO
import retrofit2.Response

import retrofit2.http.GET

interface HouseListApiService {
    @GET("houses")
    suspend fun getHouseMemberList(): Response<List<MemberListDTO>>
}