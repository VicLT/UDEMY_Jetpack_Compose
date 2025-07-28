package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {

    val names = listOf(
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón",
        "Aris",
        "Pepe",
        "Ramón"
    )

//    Column {
//        names.forEach {
//            Text(it)
//        }
//    }

    LazyColumn {
        items(names) {
            Text(
                it,
                modifier = Modifier
                    .padding(24.dp)
                    .clickable { onItemClick(it) }
            )
        }
    }
}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(List(100) { "Item número $it" })
    }

    LazyColumn {
        item {
            Button(onClick = {
                // Al presionar el botón por segunda vez intenta poner dos
                // elementos con la misma key y crashea
                items = items.toMutableList().apply { add(0, "Hola") }
            }) {
                Text("Añadir item")
            }
        }
        itemsIndexed(
            items,
            key = { _, item -> item }
        ) { index, item ->
            Row {
                Text("$item - Índice: $index")
                Spacer(Modifier.weight(1f))
                TextButton(
                    onClick = {
                        items = items.toMutableList().apply {
                            // remove(item)
                            removeAt(index)
                        }
                    }
                ) {
                    Text("Borrar")
                }
                Spacer(Modifier.width(24.dp))
            }
        }
    }
}







