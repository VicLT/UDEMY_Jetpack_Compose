package udemy.victorlamas.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import java.util.Calendar

@Composable
fun MyDialog(modifier: Modifier = Modifier) {

    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("¡Entendido!")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },
            text = { Text("Esta es mi descripción") },
            title = { Text("¿Quieres hacer esta acción?") },
            icon = {
                Icon(
                    modifier = Modifier.size(60.dp),
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(12),
            containerColor = Color.Yellow,
            iconContentColor = Color.Red,
            titleContentColor = Color.Magenta,
            textContentColor = Color.Cyan,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {

    var showDialog by remember { mutableStateOf(true) }
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2025,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar = Calendar.getInstance().apply {
                    timeInMillis = utcTimeMillis
                }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }
    )

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis
                    if (result != null) {
                        val newCalendar =
                            Calendar.getInstance().apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        Log.i("FECHA SELECCIONADA", "DIA: $day, MES: $month")
                    }
                }) {
                    Text("Confirmar")
                }
            },
            colors = DatePickerDefaults.colors()
        ) {
            DatePicker(datePickerState)
        }
    }
}