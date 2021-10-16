package tech.gamedev.scared.ui.components.screens.core.book

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tech.gamedev.scared.data.models.Feature
import tech.gamedev.scared.data.models.Story
import tech.gamedev.scared.viewmodels.StoryViewModel

@ExperimentalFoundationApi
@Composable
fun BooksSection(features: List<Feature>, title: String = "Short stories", navController: NavController, stories: List<Story>, storyViewModel: StoryViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(stories.size) {
                StoryItem(feature = features[getFeatureIndex(it)], navController, stories[it], storyViewModel)
            }
        }
    }
}

fun getFeatureIndex(index: Int) : Int {
    return if(index % 1 == 0) {
        0
    } else if(index % 2 == 0) {
        1
    } else if(index % 3 == 0) {
        2
    } else if(index % 4 == 0) {
        3
    } else {
        5
    }
}
