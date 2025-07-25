package udemy.victorlamas.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import udemy.victorlamas.myfirstcomposeapp.components.MyDivider
import udemy.victorlamas.myfirstcomposeapp.login.Greeting
import udemy.victorlamas.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyDivider(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyFirstComposeAppTheme {
//                val drawerState =
//                    rememberDrawerState(initialValue = DrawerValue.Closed)
//                val snackbarHostState = remember { SnackbarHostState() }
//                val scope = rememberCoroutineScope()
//
//                MyModalDrawer(drawerState) {
//                    Scaffold(
//                        modifier = Modifier.fillMaxSize(),
//                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
//                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
//                        floatingActionButton = { MyFAB() },
//                        floatingActionButtonPosition = FabPosition.Center,
//                        bottomBar = { MyNavigationBar() }
//                    ) { innerPadding ->
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(innerPadding)
//                                .background(Color.Cyan),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(
//                                "Esta es mi screen",
//                                modifier = Modifier.clickable {
//                                    scope.launch {
//                                        val result =
//                                            snackbarHostState.showSnackbar(
//                                                message = "Eliminado",
//                                                actionLabel = "Deshacer",
//                                                duration = SnackbarDuration.Short
//                                            )
//
//                                        if (result == SnackbarResult.ActionPerformed) {
//                                            // Usuario pulsa "deshacer"
//                                            snackbarHostState.showSnackbar(
//                                                message = "Deshecho"
//                                            )
//                                        } else {
//                                            // Usuario no hace nada
//                                            snackbarHostState.showSnackbar(
//                                                message = "Confirmado"
//                                            )
//                                        }
//                                    }
//                                }
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}