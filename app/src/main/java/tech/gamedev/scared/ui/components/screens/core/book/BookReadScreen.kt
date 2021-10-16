package tech.gamedev.scared.ui.components.screens.core.book

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tech.gamedev.scared.R
import tech.gamedev.scared.data.models.Story
import tech.gamedev.scared.viewmodels.MainViewModel
import tech.gamedev.scared.viewmodels.StoryViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun BookReadScreen(viewModel: MainViewModel, navController: NavHostController, storyViewModel: StoryViewModel) {
    val scroll = rememberScrollState(0)
    val story by remember { storyViewModel.currentStory }
    Image(
        painterResource(R.drawable.book_page),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text(
            text = story.story,
            modifier = Modifier.verticalScroll(scroll),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = Color.Black
        )
    }

    BackHandler() {
        navController.navigate("reading")
    }
}