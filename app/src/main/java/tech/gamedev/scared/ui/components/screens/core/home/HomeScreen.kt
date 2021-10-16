package tech.gamedev.scared.ui.components.screens.core.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import tech.gamedev.scared.R
import tech.gamedev.scared.data.models.Feature
import tech.gamedev.scared.ui.components.screens.core.home.elements.CategorySection
import tech.gamedev.scared.ui.components.screens.core.home.elements.CurrentStorySection
import tech.gamedev.scared.ui.components.screens.core.home.elements.FeaturedSection
import tech.gamedev.scared.ui.components.screens.core.home.elements.GreetingSection
import tech.gamedev.scared.ui.theme.*
import tech.gamedev.scared.viewmodels.MainViewModel
import androidx.compose.runtime.mutableStateOf


@ExperimentalFoundationApi
@Composable
fun HomeScreen(mainViewModel: MainViewModel, navController: NavHostController) {


    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()

    ) {
        Column {
            GreetingSection()
            CategorySection(categories = listOf("Mystery", "Insomnia", "Ghost", "True stories", "Horror", "Aliens"))
            CurrentStorySection(
                mainViewModel = mainViewModel
            )
            FeaturedSection(
                features = listOf(
                    Feature(
                        title = "Audio Stories",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Video",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "To Read",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Reddit",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                ), navController = navController
            )
        }
    }
}






