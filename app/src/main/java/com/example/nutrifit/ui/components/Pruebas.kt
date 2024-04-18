package com.example.nutrifit.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Games
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.nutrifit.ui.screens.ObjectivesUserScreen

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Pruebas() {
    var selectedButton by remember { mutableIntStateOf(0) }
    val buttons = getNavigationButtons()

    NavigationBar {
        buttons.forEachIndexed { index, button ->
            NavigationBarItem(
                label = { Text(button.title) },
                selected = selectedButton == index,
                onClick = {
                    selectedButton = index
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (button.badgeCount != null) {
                                Badge {
                                    Text(text = button.badgeCount.toString())
                                }
                            } else if (button.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = button.icon,
                            contentDescription = button.title,
                            tint = if (index == selectedButton) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }
    }
}

data class NavigationButton(
    val title: String,
    val icon: ImageVector,
    val screen: String,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

fun getNavigationButtons(): List<NavigationButton> {
    return listOf(
        NavigationButton(
            title = "Home",
            icon = Icons.Rounded.Home,
            screen = "Home",
            hasNews = false
        ),
        NavigationButton(
            title = "Games",
            icon = Icons.Rounded.Games,
            screen = "Games",
            hasNews = false
        ),
        NavigationButton(
            title = "Favorites",
            icon = Icons.Rounded.Favorite,
            screen = "Favorites",
            hasNews = false
        ),
        NavigationButton(
            title = "News",
            icon = Icons.Rounded.Message,
            screen = "News",
            hasNews = true,
            badgeCount = 2
        ),
        NavigationButton(
            title = "Profile",
            icon = Icons.Rounded.Person,
            screen ="Profile",
            hasNews = false
        )
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewObjectivesUserScreen() {
    ObjectivesUserScreen()
}