package com.example.newsdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.MemberDetailsEntity
import com.example.presentation.base.intent.MemberDetailIntent
import com.example.presentation.base.state.HouseMemberState
import com.example.presentation.base.widget.BaseScreen
import com.example.presentation.base.widget.ErrorContent
import com.example.presentation.base.widget.LoadingContent

@Composable
fun HouseMemberDetailScreen(
    viewModel: HouseMemberDetailViewModel = hiltViewModel(),
    id: String,
    onBack: () -> Unit
){
    val state = viewModel.uiState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.handleIntent(MemberDetailIntent.LoadNewsDetails, id)
    }

    HouseMemberDetailScreenRender(
        state = state,
        onBack = onBack
    )
}

@Composable
fun HouseMemberDetailScreenRender(
    state: HouseMemberState<List<MemberDetailsEntity>>,
    onBack: () -> Unit
) {
    BaseScreen(
        title = "Details",
        showBackButton = true,
        onBackPressed = onBack
    ) {
        state.let {
            when (it){
                is HouseMemberState.Loading -> {  LoadingContent() }
                is HouseMemberState.Success -> { }
                is HouseMemberState.Error -> { ErrorContent(message = it.message) }
            }
        }
    }
}
