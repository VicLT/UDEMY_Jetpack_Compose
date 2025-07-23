@file:OptIn(ExperimentalMaterial3Api::class)

package udemy.victorlamas.myfirstcomposeapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {

    var myValue by remember { mutableFloatStateOf(0.5f) }

    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            enabled = false,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                activeTickColor = Color.Magenta,
                disabledActiveTrackColor = Color.Gray,
                disabledActiveTickColor = Color.Magenta,
                inactiveTrackColor = Color.Blue,
                inactiveTickColor = Color.Cyan,
                disabledInactiveTrackColor = Color.DarkGray,
                disabledInactiveTickColor = Color.Magenta
            )
        )
        Text(myValue.toString())
    }
}

@Composable
fun MyAdvancedSlider(modifier: Modifier = Modifier) {

    var example by remember { mutableStateOf("=(") }
    val state = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = { example = "FELIZ" }
        )
    }

    val colors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        activeTickColor = Color.Magenta,
        disabledActiveTrackColor = Color.Gray,
        disabledActiveTickColor = Color.Magenta,
        inactiveTrackColor = Color.Blue,
        inactiveTickColor = Color.Cyan,
        disabledInactiveTrackColor = Color.DarkGray,
        disabledInactiveTickColor = Color.Magenta
    )

    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            state = state,
            colors = colors,
            //thumb = { state: SliderState -> Text(state.value.toString()) })
            thumb = {
                Box(
                    Modifier
                        .width(10.dp)
                        .height(30.dp)
                        .background(Color.Green)
                )
            },
            track = {
                Box(
                    Modifier
                        .height(20.dp)
                        .width(200.dp)
                        .background(Color.Black)
                )
            }
        )
        Text(example)
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {

    val state = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            steps = 8,
            onValueChangeFinished = {}
        )
    }

    val colors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        activeTickColor = Color.Magenta,
        disabledActiveTrackColor = Color.Gray,
        disabledActiveTickColor = Color.Magenta,
        inactiveTrackColor = Color.Blue,
        inactiveTickColor = Color.Cyan,
        disabledInactiveTrackColor = Color.DarkGray,
        disabledInactiveTickColor = Color.Magenta
    )

    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        RangeSlider(
            state = state,
            colors = colors,
            startThumb = {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(String.format("%.1f", it.activeRangeStart))
                }
            },
            endThumb = {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(String.format("%.1f", it.activeRangeEnd))
                }
            }
        )
    }
}










