package udemy.victorlamas.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.DetailScreen
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.HomeScreen
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.LoginScreen
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.SettingsScreen
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.model.SettingsModel
import udemy.victorlamas.myfirstcomposeapp.components.navigation.types.createNavType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToDetail = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { id, booleanValue ->
                    navController.navigate(Detail(id = id, test = booleanValue))
                }
            )
        }

        composable<Detail> { navBackStackEntry ->
            //val detail = navBackStackEntry.toRoute<Detail>()
            val detail: Detail = navBackStackEntry.toRoute()
            //detail.test

            DetailScreen(
                id = detail.id,
                navigateToSettings = {
                    navController.navigate(Settings(it))
                }
            )
        }

        composable<Settings>(
            typeMap = mapOf(typeOf<SettingsModel>() to createNavType<SettingsModel>())
        ) { navBackStackEntry ->
            val settings: Settings = navBackStackEntry.toRoute()
            SettingsScreen(
                settingsModel = settings.settingsModel,
                navigateToHome = {
                    navController.navigate(Login) {
                        popUpTo<Login> {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}