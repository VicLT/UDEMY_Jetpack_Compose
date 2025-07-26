package udemy.victorlamas.myfirstcomposeapp.components.advanced

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InteractionSourceExample(modifier: Modifier = Modifier) {
    val interaction = remember { MutableInteractionSource() }
    val isPressed by interaction.collectIsPressedAsState()

    Box(
        Modifier
            .size(150.dp)
            .shadow(if (isPressed) 16.dp else 4.dp)
            //.background(if (isPressed) Color.Red else Color.White)
            .background(Color.White)
            .clickable(
                interactionSource = interaction,
                indication = LocalIndication.current
            ) {},
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(onClick = {}, interactionSource = interaction) {
                Text("Example")
            }
            Text(text = if (isPressed) "Pulsado" else "Sin pulsar")

        }
    }
}