package tech.gamedev.scared.ui.components.screens.core.book

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import tech.gamedev.scared.R
import tech.gamedev.scared.data.models.Feature
import tech.gamedev.scared.ui.components.screens.core.home.elements.CategorySection
import tech.gamedev.scared.ui.components.screens.core.home.elements.FeaturedSection
import tech.gamedev.scared.ui.theme.*
import tech.gamedev.scared.viewmodels.MainViewModel
import tech.gamedev.scared.viewmodels.StoryViewModel

@ExperimentalFoundationApi
@Composable
fun BookScreen(
    mainViewModel: MainViewModel,
    navController: NavHostController,
    storyViewModel: StoryViewModel
) {
    val stories = storyViewModel.stories.observeAsState()

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()

    ) {
        Column {
            CategorySection(categories = listOf("Mystery", "Insomnia", "Ghost", "True stories", "Horror", "Aliens"))

            BooksSection(features = listOf(
                Feature(
                    title = "",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                Feature(
                    title = "",
                    R.drawable.ic_videocam,
                    LightGreen1,
                    LightGreen2,
                    LightGreen3
                ),
                Feature(
                    title = "",
                    R.drawable.ic_headphone,
                    OrangeYellow1,
                    OrangeYellow2,
                    OrangeYellow3
                ),
                Feature(
                    title = "",
                    R.drawable.ic_headphone,
                    Beige1,
                    Beige2,
                    Beige3
                )
            ), title = "Books - Categories", navController = navController, stories.value!!, storyViewModel = storyViewModel
            )
        }
    }
}