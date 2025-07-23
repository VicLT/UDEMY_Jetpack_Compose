package udemy.victorlamas.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! PEPITO",
        modifier = modifier
    )
}

@Preview
@Composable
fun ExamplePreview() {
    Example("PEPE")
}

@Composable
fun Example(a: String) {
    Text("Victor $a", modifier = Modifier
        .background(Color.Red)
        .padding(top = 30.dp)
        .clickable { }
    )
}
