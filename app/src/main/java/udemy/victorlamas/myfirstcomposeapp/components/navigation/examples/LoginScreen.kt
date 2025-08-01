package udemy.victorlamas.myfirstcomposeapp.components.navigation.examples

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateToHome: () -> Unit) {
    var showView by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text("LOGIN", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateToHome() }) {
            Text("Home")
        }
        Button(onClick = { showView = true }) {
            Text("Red view in login")
        }
        Spacer(Modifier.weight(1f))
    }

    if (showView) {
        BackHandler {
            showView = false
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Red)
        )
    }
}