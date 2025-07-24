package udemy.victorlamas.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import udemy.victorlamas.myfirstcomposeapp.components.MyFAB
import udemy.victorlamas.myfirstcomposeapp.components.MyNavigationBar
import udemy.victorlamas.myfirstcomposeapp.components.MyTopAppBar
import udemy.victorlamas.myfirstcomposeapp.login.Greeting
import udemy.victorlamas.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    floatingActionButton = { MyFAB() },
                    floatingActionButtonPosition = FabPosition.Center,
                    bottomBar = { MyNavigationBar() }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(Color.Cyan),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Esta es mi screen",
                            modifier = Modifier.clickable {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Eliminado",
                                        actionLabel = "Deshacer",
                                        duration = SnackbarDuration.Short
                                    )

                                    if (result == SnackbarResult.ActionPerformed) {
                                        // Usuario pulsa "deshacer"
                                        snackbarHostState.showSnackbar(
                                            message = "Deshecho"
                                        )
                                    } else {
                                        // Usuario no hace nada
                                        snackbarHostState.showSnackbar(
                                            message = "Confirmado"
                                        )
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}