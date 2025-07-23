package udemy.victorlamas.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import udemy.victorlamas.myfirstcomposeapp.R

@Composable
fun MyImage(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Yellow)
    ) {
        Image(
            painter = painterResource(R.drawable.aprilia),
            contentDescription = "Avatar image profile",
            modifier = Modifier
                .background(Color.Black)
                .size(300.dp)
                .align(Alignment.CenterHorizontally)
                //.clip(CircleShape),
                //.clip(RoundedCornerShape(bottomEnd = 70.dp, topEnd = 30.dp))
                .clip(RoundedCornerShape(50))
                .border(
                    width = 5.dp, /*color = Color.Red,*/
                    shape = CircleShape,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                            Color.Yellow
                        )
                    )
                ),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun MyIcon(modifier: Modifier) {
    Icon(
        painter = painterResource(R.drawable.ic_senderista),
        contentDescription = null,
        modifier = modifier.size(300.dp),
        tint = Color.Blue
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(
        model = "https://wlassets.aprilia.com/wlassets/aprilia/master/Range/RSV4/family_page/2025/wall-image/Aprilia_RSV4_wall-image_1920x1440_1/original/Aprilia_RSV4_wall-image_1920x1440_1.jpg?1743413062163",
        contentDescription = "Image from network",
        onError = {
            Log.i(
                "Image",
                "Ha ocurrido un error ${it.result.throwable.message}"
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(200.dp)
            .clip(CircleShape)
            .border(
                width = 5.dp, /*color = Color.Red,*/
                shape = CircleShape,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Blue,
                        Color.Yellow
                    )
                )
            ),
        contentScale = ContentScale.FillWidth
    )
}

















