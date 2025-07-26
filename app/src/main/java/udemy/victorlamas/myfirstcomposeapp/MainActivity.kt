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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import udemy.victorlamas.myfirstcomposeapp.components.MyCustomDialog
import udemy.victorlamas.myfirstcomposeapp.components.MyFAB
import udemy.victorlamas.myfirstcomposeapp.components.MyModalDrawer
import udemy.victorlamas.myfirstcomposeapp.components.MyNavigationBar
import udemy.victorlamas.myfirstcomposeapp.components.MyTopAppBar
import udemy.victorlamas.myfirstcomposeapp.components.advanced.InteractionSourceExample
import udemy.victorlamas.myfirstcomposeapp.components.model.PokemonCombat
import udemy.victorlamas.myfirstcomposeapp.login.Greeting
import udemy.victorlamas.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyFirstComposeAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MyDivider(Modifier.padding(innerPadding))
//                }
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val drawerState =
                    rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat =
                    PokemonCombat(pokemonA = "Pikachu", pokemonB = "Bulbasur")

                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = {
                        // Iniciar el combate
                        showDialog = false
                    },
                    onDismissDialog = { showDialog = false }
                )

                MyModalDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        floatingActionButton = { MyFAB { showDialog = true } },
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
                                        val result =
                                            snackbarHostState.showSnackbar(
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

                            InteractionSourceExample()
                        }
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