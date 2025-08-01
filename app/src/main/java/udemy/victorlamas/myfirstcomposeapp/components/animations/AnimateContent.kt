package udemy.victorlamas.myfirstcomposeapp.components.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimateContent(modifier: Modifier = Modifier) {
    var number by remember { mutableIntStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { number++ }) {
            Text("Sumar")
        }
        Spacer(Modifier.height(32.dp))
        AnimatedContent(targetState = number) { result ->
            when (result) {
                0 -> Box(Modifier
                    .size(50.dp)
                    .background(Color.Red))
                1 -> Text("Número 1")
                2 -> FloatingActionButton(onClick = {}) { }
                3 -> Box(Modifier
                    .size(150.dp)
                    .background(Color.Blue))
            }
        }
    }
}