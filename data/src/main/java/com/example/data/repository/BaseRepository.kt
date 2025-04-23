package com.example.data.repository

import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

suspend fun <T,R> safeApiCall(
    apiCall: suspend () -> Response<T>,
    mapper: (T) -> R,
): Flow<Result<R>> = flow<Result<R>> {
    val response = apiCall()
    with(response){
        response.isSuccessful.let {
            val data = body()
            data?.let {
                val result = mapper(data)
                emit(Result.Success(result))
            } ?: run{
                val error = errorBody()
                error.let {
                    emit(Result.Error("Data Not Available"))
                } ?: run {
                    emit(Result.Error("Data Not Available"))
                }
            }
        }
    }
}.catch { exc ->
    emit(Result.Error(exc.message.toString()))
}