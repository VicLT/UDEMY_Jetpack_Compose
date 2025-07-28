package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

    LazyRow {
        items(names) {
            Text(
                it,
                modifier = Modifier
                    .padding(24.dp)
                    .clickable { onItemClick(it) })
        }
    }
}