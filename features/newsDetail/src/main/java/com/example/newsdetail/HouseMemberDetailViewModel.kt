package com.example.newsdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.MemberDetailsEntity
import com.example.domain.usecase.GetMemberDetailUseCase
import com.example.domain.utils.Result
import com.example.common.intent.MemberDetailIntent
import com.example.common.state.HouseMemberState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HouseMemberDetailViewModel @Inject constructor(
    private val getMemberDetailUseCase: GetMemberDetailUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<HouseMemberState<List<MemberDetailsEntity>>>(
        HouseMemberState.Loading)
    val uiState : StateFlow<HouseMemberState<List<MemberDetailsEntity>>> get() = _uiState

    fun handleIntent(intent: MemberDetailIntent, id: String){
        viewModelScope.launch {
            when(intent){
                MemberDetailIntent.LoadNewsDetails -> loadHouseDetails(id)
            }
        }
    }

    private suspend fun loadHouseDetails(id: String){
        _uiState.value = HouseMemberState.Loading
        getMemberDetailUseCase(id)
            .catch { exception ->
                _uiState.value = HouseMemberState.Error(exception.message ?: "Unknown Error")
            }
            .collect{ result ->
                when(result){
                    is Result.Success -> {
                        _uiState.value = HouseMemberState.Success(result.data)
                    }
                    is Result.Error -> {
                        _uiState.value = HouseMemberState.Error(result.error.toString())
                    }
                }
            }
    }
}