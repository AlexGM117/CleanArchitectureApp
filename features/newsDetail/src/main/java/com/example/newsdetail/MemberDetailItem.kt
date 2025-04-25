package com.example.newsdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.common.widget.Dimens.FONT_SIZE_1F
import com.example.common.widget.Dimens.eight_dp
import com.example.common.widget.Dimens.four_dp
import com.example.common.widget.Dimens.sixteen_dp
import com.example.common.widget.Dimens.ten_dp
import com.example.common.widget.TextTitle
import com.example.domain.model.MemberDetailsEntity

@Composable
fun MemberDetailItem(
    item: List<MemberDetailsEntity>
){
    val cardPadding = sixteen_dp
    val smallPadding = eight_dp
    val tinyPadding = four_dp

    Scaffold { paddingValue ->
        Column (
            modifier = Modifier
                .fillMaxSize(FONT_SIZE_1F)
                .padding(paddingValue)
        ){
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(smallPadding)
                    .clip(RoundedCornerShape(cardPadding)),
                elevation = CardDefaults.cardElevation(defaultElevation = ten_dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(cardPadding)
                ){
                    Column {
                        TextTitle(
                            name = "",
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
    }

}