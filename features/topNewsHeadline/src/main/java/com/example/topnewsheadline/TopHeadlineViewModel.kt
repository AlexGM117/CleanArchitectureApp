package com.example.topnewsheadline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.MemberListEntity
import com.example.domain.usecase.GetMemberListUseCase
import com.example.domain.utils.Result
import com.example.common.intent.MemberIntent
import com.example.common.state.HouseMemberState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadlineViewModel @Inject constructor(
    private val getMemberListUseCase: GetMemberListUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<HouseMemberState<List<MemberListEntity>>>(
        HouseMemberState.Loading)
    val uiState : StateFlow<HouseMemberState<List<MemberListEntity>>> get() = _uiState

    fun handleIntent(intent: MemberIntent){
        viewModelScope.launch {
            when(intent){
                is MemberIntent.LoadHouseMember -> {
                    (_uiState.value as? HouseMemberState.Loading)?.let {
                        loadHouseMemberList()
                    }
                }
                else -> {}
            }
        }
    }

    private suspend fun loadHouseMemberList(){
        _uiState.value = HouseMemberState.Loading
        getMemberListUseCase()
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