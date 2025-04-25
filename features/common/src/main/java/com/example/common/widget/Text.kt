package com.example.common.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.widget.Dimens.bottomPadding
import com.example.common.widget.Dimens.endPadding
import com.example.common.widget.Dimens.startPadding
import com.example.common.widget.Dimens.topPadding

@Composable
fun TextTitle(
    name: String,
    modifier: Modifier,
    color: Color,
    fontWeight: FontWeight,
    style: TextStyle
){
    Text(
        text = name,
        modifier = modifier.padding(startPadding, topPadding, endPadding, bottomPadding),
        fontWeight = fontWeight,
        style = style,
        color = color
    )
}

@Preview
@Composable
fun TextTitlePrivate(){
    TextTitle(
        name = "Thrones",
        modifier = Modifier,
        color = MaterialTheme.colorScheme.surface,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleMedium
    )
}