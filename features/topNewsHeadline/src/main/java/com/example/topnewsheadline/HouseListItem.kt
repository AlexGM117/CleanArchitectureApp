package com.example.topnewsheadline

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.common.widget.Dimens.eight_dp
import com.example.common.widget.Dimens.sixteen_dp
import com.example.common.widget.Dimens.ten_dp
import com.example.common.widget.TextTitle
import com.example.domain.model.MemberListEntity
import com.example.presentation.base.intent.MemberIntent

@Composable
fun HouseListItem(
    item : List<MemberListEntity>,
    onItemSelected: (MemberIntent) -> Unit,
){
    val members: List<MemberListEntity> = item
    for (member in members){
        println("MEMBER" + member)
    }
    LazyColumn {
        items(item) { renderItems ->
            RenderItem(
                item = renderItems,
                onItemSelected
            )
        }
    }
}

@Composable
fun RenderItem(
    item: MemberListEntity,
    onItemSelected: (MemberIntent) -> Unit
) {
    val padding = sixteen_dp
    val cardPadding = eight_dp

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(cardPadding)
            .clip(
                RoundedCornerShape(padding)
            )
            .clickable(onClick = {
                onItemSelected(MemberIntent.onListSelected(item.name)
                )
            }),
        elevation = CardDefaults.cardElevation(defaultElevation = ten_dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
                .wrapContentHeight()
        ){
            Column {
                TextTitle(
                    name = item.slug,
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(cardPadding))
            }
        }
    }
}
