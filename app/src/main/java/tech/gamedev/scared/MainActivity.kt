package tech.gamedev.scared

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import tech.gamedev.scared.data.models.BottomMenuContent
import tech.gamedev.scared.other.Status
import tech.gamedev.scared.ui.components.bottommenu.BottomMenu
import tech.gamedev.scared.ui.components.bottommenu.Navigation
import tech.gamedev.scared.ui.theme.StorytimeScaryStoriesTheme
import tech.gamedev.scared.viewmodels.MainViewModel
import tech.gamedev.scared.viewmodels.StoryViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private val storyViewModel by viewModels<StoryViewModel>()
    @ExperimentalCoroutinesApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToObservers()
        setContent {
            StorytimeScaryStoriesTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomMenu(items = listOf(
                            BottomMenuContent("Home", R.drawable.ic_home),
                            BottomMenuContent("Video", R.drawable.ic_bubble),
                            BottomMenuContent("Books", R.drawable.ic_moon),
                            BottomMenuContent("Audio", R.drawable.ic_music),
                            BottomMenuContent("Profile", R.drawable.ic_profile),
                        ),
                            modifier = Modifier,
                            navController = navController
                        )
                    }
                ) {
                    Navigation(navController = navController, mainViewModel, storyViewModel)
                }

            }
        }
    }

    private fun subscribeToObservers() {
        mainViewModel.mediaItems.observe(this) {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { songs ->
                            Log.d("EXOPLAYER", "songs size :$${songs.size}")
                        }
                    }
                    Status.ERROR -> Unit
                    Status.LOADING -> Unit
                }
            }
        }
        mainViewModel.curPlayingSong.observe(this) {
            if (it == null) return@observe
            Log.d("EXOPLAYER", "songs size :$${it.description.title}")
//            curPlayingSong = it.toSong()
//            glide.load(curPlayingSong?.imageUrl).into(ivCurSongImage)
//            switchViewPagerToCurrentSong(curPlayingSong ?: return@observe)


        }
        mainViewModel.playbackState.observe(this) {
//            playbackState = it
//            ivPlayPause.setImageResource(
//                if (playbackState?.isPlaying == true) R.drawable.ic_pause else R.drawable.ic_play
//            )
        }
        mainViewModel.isConnected.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.ERROR -> Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                    else -> Unit
                }
            }
        }
        mainViewModel.networkError.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.ERROR -> Toast.makeText(this, "There seems to be a problem with your connection", Toast.LENGTH_SHORT).show()
                    else -> Unit
                }
            }
        }
    }
}

