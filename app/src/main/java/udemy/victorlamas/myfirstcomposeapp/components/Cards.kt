package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(2.dp, Color.Red),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green,
            contentColor = Color.Blue,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.DarkGray
        ),
        enabled = false,
        onClick = {}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            ) {}
            Column {
                Text(
                    "Víctor 1",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    "Víctor 2",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun MyElevatedCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            ) {}
            Column {
                Text(
                    "Víctor 1",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    "Víctor 2",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun MyOutlinedCard(modifier: Modifier = Modifier) {
    OutlinedCard (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            ) {}
            Column {
                Text(
                    "Víctor 1",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    "Víctor 2",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}








