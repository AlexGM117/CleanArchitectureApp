package com.example.topnewsheadline

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common.intent.MemberIntent
import com.example.common.widget.BaseScreen
import com.example.common.widget.ErrorContent
import com.example.common.widget.LoadingContent
import com.example.domain.model.MemberListEntity
import com.example.common.state.HouseMemberState

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
        Text(text = "My first composable")
    }
}

@Composable
@Preview(
    showBackground = true
)
fun TopHeadlineScreenPreview() {
    HouseScreenRendering(
        state = HouseMemberState.Success(
            data = listOf()
        ),
        onItemSelected = {}
    )
}
