package udemy.victorlamas.myfirstcomposeapp.components.navigation

import kotlinx.serialization.Serializable
import udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.model.SettingsModel

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test: Boolean)

@Serializable
data class Settings(val settingsModel: SettingsModel)