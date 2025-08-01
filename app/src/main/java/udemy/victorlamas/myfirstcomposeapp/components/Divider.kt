package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Parte de arriba")
        HorizontalDivider(thickness = 3.dp, color = Color.Red)
        Text("Parte de abajo")
    }

    Row(
        modifier = modifier
            .fillMaxHeight()
            .padding(horizontal = 50.dp)
            .height(400.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Izquierda")
        VerticalDivider(thickness = 3.dp, color = Color.Blue)
        Text("Derecha")
    }
}