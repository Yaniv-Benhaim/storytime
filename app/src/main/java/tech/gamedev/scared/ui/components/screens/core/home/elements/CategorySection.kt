package tech.gamedev.scared.ui.components.screens.core.home.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import tech.gamedev.scared.ui.theme.ButtonBlue
import tech.gamedev.scared.ui.theme.DarkerButtonBlue
import tech.gamedev.scared.ui.theme.TextWhite

@Composable
fun CategorySection(
    categories: List<String>
) {
    var selectedCategoryIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(categories.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedCategoryIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedCategoryIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = categories[it], color = TextWhite)
            }
        }
    }
}