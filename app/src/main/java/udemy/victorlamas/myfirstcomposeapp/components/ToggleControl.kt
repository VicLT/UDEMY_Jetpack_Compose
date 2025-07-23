package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import udemy.victorlamas.myfirstcomposeapp.R
import udemy.victorlamas.myfirstcomposeapp.components.state.CheckboxState

@Composable
fun MySwitch(modifier: Modifier) {

    var state by remember { mutableStateOf(true) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Switch(
            checked = state,
            onCheckedChange = { state = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_senderista),
                    contentDescription = null
                )
            },
            enabled = false,
            colors = SwitchDefaults.colors(
                // Bolita
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Cyan,
                // Icono
                checkedIconColor = Color.Green,
                uncheckedIconColor = Color.Cyan,
                disabledCheckedIconColor = Color.Red,
                disabledUncheckedIconColor = Color.Red,
                // Borde
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Magenta,
                // Track
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Black,
                disabledCheckedTrackColor = Color.White,
                disabledUncheckedTrackColor = Color.Black
            )
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier) {

    var state by remember { mutableStateOf(true) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }
        ) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Red,
                    disabledCheckedColor = Color.Black,
                    disabledUncheckedColor = Color.Cyan,
                    checkmarkColor = Color.Blue
                )
            )
            Spacer(Modifier.padding(6.dp))
            Text("Acepto los términos y condiciones")
        }
    }
}

@Composable
fun ParentCheckboxes(modifier: Modifier) {

    var states by remember {
        mutableStateOf(
            listOf(
                CheckboxState(
                    "terms",
                    "Aceptar los términos y condiciones"
                ),
                CheckboxState(
                    "newsletter",
                    "Recibir la newsletter",
                    true
                ),
                CheckboxState(
                    "updates",
                    "Recibir actualizaciones"
                ),
            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        states.forEach { myState ->
            CheckboxWithText(checkboxState = myState) {
                states = states.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckboxWithText(
    modifier: Modifier = Modifier,
    checkboxState: CheckboxState,
    onCheckedChange: (CheckboxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onCheckedChange(checkboxState) }
    ) {
        Checkbox(
            checked = checkboxState.checked,
            onCheckedChange = { onCheckedChange(checkboxState) },
            enabled = true
        )
        Spacer(Modifier.padding(6.dp))
        Text(checkboxState.label)
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {

    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = newState
            })
            Text("Seleccionar todo")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child1, onCheckedChange = { child1 = it })
            Text("Ejemplo 2")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Ejemplo 2")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier) {

    var state by remember { mutableStateOf(false) }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state,
            onClick = { state = true },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Magenta
            )
        )
        Text("Ejemplo 1")
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {

    var selectedName by remember { mutableStateOf("") }

    Column(modifier = modifier) {
//        RadioButtonComponent(
//            name = "Aris",
//            selectedName = selectedName
//        ) { selectedName = it }
        RadioButtonComponent(
            name = "Aris",
            selectedName = selectedName,
            onItemSelected = { selectedName = it }
        )
        RadioButtonComponent(
            name = "Pepe",
            selectedName = selectedName
        ) { selectedName = it }
        RadioButtonComponent(
            name = "David",
            selectedName = selectedName
        ) { selectedName = it }
        RadioButtonComponent(
            name = "Coors",
            selectedName = selectedName
        ) { selectedName = it }
        RadioButtonComponent(
            name = "Juan",
            selectedName = selectedName
        ) { selectedName = it }
        RadioButtonComponent(
            name = "Der",
            selectedName = selectedName
        ) { selectedName = it }
    }
}

@Composable
fun RadioButtonComponent(
    name: String,
    selectedName: String,
    onItemSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        //modifier = Modifier.clickable { onItemSelected(name) }
    ) {
        RadioButton(
            selected = name == selectedName,
            onClick = { onItemSelected(name) }
        )
        Text(name)
    }
}


















