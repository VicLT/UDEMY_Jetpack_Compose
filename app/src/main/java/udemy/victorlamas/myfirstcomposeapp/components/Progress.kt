package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import udemy.victorlamas.myfirstcomposeapp.R

@Composable
fun Progress(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier.size(150.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Butt
        )
        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator(
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Square
        )
    }
}

@Composable
fun ProgressAdvanced(modifier: Modifier) {

    var progress by remember { mutableFloatStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(targetValue = progress)

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                modifier.size(150.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Butt
            )
        }
        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator(
            progress = { animatedProgress },
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Square
        )
        Row(Modifier.padding(24.dp)) {
            Button(onClick = { progress -= 0.1f }) { Text("<-") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = { progress += 0.1f }) { Text("->") }
        }
        Button(onClick = { isLoading = !isLoading }) { Text("Show/hide") }
    }
}

@Composable
fun ProgressAnimation(modifier: Modifier) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.cute_doggie)
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            //iterations = LottieConstants.IterateForever
        )
    }
}