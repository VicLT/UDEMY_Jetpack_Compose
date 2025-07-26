package udemy.victorlamas.myfirstcomposeapp.components.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDerivedStateOf(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //val isFormValid = email.contains("") && password.length > 4
    val isFormValid by remember(email, password) {
        derivedStateOf {
            email.contains("@") && password.length > 4
        }
    }

    Column(modifier = Modifier.background(Color.White)) {
        TextField(value = email, onValueChange = { email = it })
        Spacer(Modifier.height(24.dp))
        TextField(value = password, onValueChange = { password = it })
        Spacer(Modifier.height(24.dp))
        Button(onClick = {}, enabled = isFormValid) {
            Text("Login")
        }
    }
}