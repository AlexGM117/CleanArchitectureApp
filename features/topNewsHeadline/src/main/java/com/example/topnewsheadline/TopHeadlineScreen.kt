package com.example.topnewsheadline

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.MemberListEntity
import com.example.presentation.base.intent.MemberIntent
import com.example.presentation.base.state.HouseMemberState
import com.example.presentation.base.widget.BaseScreen
import com.example.presentation.base.widget.ErrorContent
import com.example.presentation.base.widget.LoadingContent

@Composable
fun TopHeadlineScreen(
    viewModel: TopHeadlineViewModel = hiltViewModel(),
    navigationToDetail: (id: String) -> Unit
){
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.handleIntent(MemberIntent.LoadHouseMember)
    }

    HouseScreenRendering(
        state = state,
        onItemSelected = { newsIntent ->
            (newsIntent as? MemberIntent.onListSelected)
                ?.let { navigationToDetail(it.id) }
        }
    )
}

@Composable
fun HouseScreenRendering(
    state: HouseMemberState<List<MemberListEntity>>,
    onItemSelected: (MemberIntent) -> Unit
){
    BaseScreen(title = stringResource(R.string.home)) {
        when(state){
            is HouseMemberState.Loading -> {
                Log.v("INFO", "Loading")
                LoadingContent()
            }

            is HouseMemberState.Success -> {
                Log.v("INFO", "Success")
                HouseListItem(
                    item = state.data,
                    onItemSelected = onItemSelected
                )
            }

            is HouseMemberState.Error -> {
                Log.v("INFO", "Error")
                ErrorContent(message = state.message)
            }
        }
    }

}
