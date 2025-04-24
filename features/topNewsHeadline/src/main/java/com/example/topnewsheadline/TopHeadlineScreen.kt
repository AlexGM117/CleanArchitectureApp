package com.example.topnewsheadline

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.base.intent.MemberIntent

@Composable
fun TopHeadlineScreen(
    viewModel: TopHeadlineViewModel = hiltViewModel(),
    navigationToDetail: (id: String) -> Unit
){
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.handleIntent(MemberIntent.LoadHouseMember)
    }

    Text("hello")
}