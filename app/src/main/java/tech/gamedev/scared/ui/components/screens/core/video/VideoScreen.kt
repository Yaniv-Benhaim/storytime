package tech.gamedev.scared.ui.components.screens.core.video

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.gamedev.scared.viewmodels.MainViewModel

@Composable
fun VideoScreen(viewModel: MainViewModel, navController: NavHostController) {
    Text(text = "VIDEO")
}