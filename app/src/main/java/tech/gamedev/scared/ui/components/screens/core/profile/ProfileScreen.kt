package tech.gamedev.scared.ui.components.screens.core.profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.gamedev.scared.viewmodels.MainViewModel

@Composable
fun ProfileScreen(viewModel: MainViewModel, navController: NavHostController) {
    Text(text = "PROFILE")
}