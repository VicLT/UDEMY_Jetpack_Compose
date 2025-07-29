package udemy.victorlamas.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.HomeScreen
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToDetail = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(navigateBack = { navController.popBackStack() })
        }
    }
}