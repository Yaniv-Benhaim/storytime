package tech.gamedev.scared.ui.components.bottommenu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import tech.gamedev.scared.ui.components.screens.core.audio.AudioScreen
import tech.gamedev.scared.ui.components.screens.core.book.BookReadScreen
import tech.gamedev.scared.ui.components.screens.core.book.BookScreen
import tech.gamedev.scared.ui.components.screens.core.home.HomeScreen
import tech.gamedev.scared.ui.components.screens.core.profile.ProfileScreen
import tech.gamedev.scared.ui.components.screens.core.video.VideoScreen
import tech.gamedev.scared.viewmodels.MainViewModel
import tech.gamedev.scared.viewmodels.StoryViewModel

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun Navigation(navController: NavHostController, mainViewModel: MainViewModel, storyViewModel: StoryViewModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(mainViewModel, navController)
        }
        composable("audio") {
            AudioScreen(mainViewModel, navController)
        }
        composable("books") {
            BookScreen(mainViewModel, navController, storyViewModel)
        }
        composable("video") {
            VideoScreen(mainViewModel, navController)
        }
        composable("profile") {
            ProfileScreen(mainViewModel, navController)
        }
        composable("reading") {
            BookReadScreen(mainViewModel, navController, storyViewModel)
        }
    }
}