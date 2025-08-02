package udemy.victorlamas.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import udemy.victorlamas.myfirstcomposeapp.components.MyCustomDialog
import udemy.victorlamas.myfirstcomposeapp.components.animations.MyInfiniteTransition
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

                MyInfiniteTransition()
//                MyContentSize()
//                MyAnimateContent()
//                MyCrossfade()
//                FullAnimateAsState()
//                MyAnimatedVisibility()
//                NavigationWrapper()

//                MyModalDrawer(drawerState) {
//                    Scaffold(
//                        modifier = Modifier.fillMaxSize(),
//                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
//                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
//                        floatingActionButton = { MyFAB { showDialog = true } },
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
//                            InteractionSourceExample()
//                            LaunchedEffect {}
//                            MyDerivedStateOf()
//                            MyBasicList {}
//                            MyAdvancedList()
//                            ScrollList()
//                            MyGridList()
//                        }
//                    }
//                }
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