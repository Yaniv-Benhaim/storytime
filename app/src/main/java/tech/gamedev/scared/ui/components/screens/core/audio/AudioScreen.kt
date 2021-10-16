package tech.gamedev.scared.ui.components.screens.core.audio

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.gamedev.scared.viewmodels.MainViewModel

@Composable
fun AudioScreen(viewModel: MainViewModel, navController: NavHostController) {
    Text(text = "AUDIO")
}