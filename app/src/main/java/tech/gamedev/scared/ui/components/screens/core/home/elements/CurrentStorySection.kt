package tech.gamedev.scared.ui.components.screens.core.home.elements

import android.media.session.PlaybackState
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import tech.gamedev.scared.R
import tech.gamedev.scared.exoplayer.isPlaying
import tech.gamedev.scared.exoplayer.toSong
import tech.gamedev.scared.ui.theme.ButtonBlue
import tech.gamedev.scared.ui.theme.LightRed
import tech.gamedev.scared.ui.theme.TextWhite
import tech.gamedev.scared.viewmodels.MainViewModel

@ExperimentalCoilApi
@Composable
fun CurrentStorySection(
    mainViewModel: MainViewModel,
    color: Color = LightRed,
) {
    val curPlayingSong = mainViewModel.curPlayingSong.observeAsState()
    val playbackState = mainViewModel.playbackState.observeAsState()
    val painter = rememberImagePainter(
        data = curPlayingSong.value?.description?.iconUri.toString(),
        builder = {
            crossfade(true)
        }
    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Max)

    ) {

        Image(
            painter = painter,
            contentDescription = "current story image",
            modifier = Modifier

                .padding(start = 15.dp, end = 15.dp, bottom = 20.dp, top = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize()
            ,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        when (painter.state) {
            is ImagePainter.State.Loading -> {
                // Display a circular progress indicator whilst loading
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            is ImagePainter.State.Error -> {
                // If you wish to display some content if the request fails
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    curPlayingSong.value
                        ?.toSong()
                        ?.let { mainViewModel.playOrToggleSong(it, true) }
                }
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()



        ) {

            Column {
                Text(
                    text = if (curPlayingSong.value == null) "Choose a story" else curPlayingSong.value?.description?.title.toString()
                        .substring(0, 20) + "...",
                    style = MaterialTheme.typography.h2,

                    )
                Text(
                    text = if (curPlayingSong.value == null) "We have hundreds of stories!" else curPlayingSong.value?.description?.subtitle.toString(),
                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)

            ) {
                Icon(
                    painter = painterResource(id = if (playbackState.value?.isPlaying == true) R.drawable.ic_pause else R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }

}
