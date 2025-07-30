package udemy.victorlamas.myfirstcomposeapp.components.navigation.examples.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingsModel(val id: String, val darkMode: Boolean): Parcelable