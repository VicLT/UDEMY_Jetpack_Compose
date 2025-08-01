package udemy.victorlamas.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.model.SettingsModel

@Composable
fun SettingsScreen(settingsModel: SettingsModel, navigateToHome: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            "SETTINGS: id:${settingsModel.id}, darkMode:${settingsModel.darkMode}",
            fontSize = 30.sp
        )
        Spacer(Modifier.weight(1f))
        Button(onClick = {  }) {
            Text("Volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}