package udemy.victorlamas.myfirstcomposeapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import udemy.victorlamas.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text("My App") },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_senderista),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_senderista),
                contentDescription = null
            )
            Icon(
                painter = painterResource(R.drawable.ic_senderista),
                contentDescription = null,
                tint = Color.Yellow
            )
            Icon(
                painter = painterResource(R.drawable.ic_senderista),
                contentDescription = null
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Magenta,
            actionIconContentColor = Color.Red,
            scrolledContainerColor = Color.Black
        ),
        //scrollBehavior =
    )
}







