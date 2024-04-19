package com.example.nutrifit.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Kitchen
import androidx.compose.material.icons.rounded.LightbulbCircle
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.SportsScore
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nutrifit.ui.navigation.NavigationScreen

@Composable
fun MainBottomBar(
    navHostController: NavHostController
) {
    var selectedButton by remember { mutableIntStateOf(0) }
    val buttons = getNavigationButtons()

    NavigationBar {
        buttons.forEachIndexed { index, button ->
            NavigationBarItem(
                label = { Text(button.title) },
                selected = selectedButton == index,
                onClick = {
                    selectedButton = index
                    navHostController.navigate(button.screen)
                },
                icon = {
                    BadgedBox(badge = {
                        if (button.badgeCount != null) {
                            Badge {
                                Text(text = button.badgeCount.toString())
                            }
                        } else if (button.hasNews) {
                            Badge()
                        }
                    }) {
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun MainBottomBarPreview() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { MainBottomBar(navController) }) {
        Text(text = "MainBottomBar")
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
            title = "Plan",
            icon = Icons.Rounded.SportsScore,
            screen = NavigationScreen.PlanScreen.route,
            hasNews = false
        ), NavigationButton(
            title = "Recipes",
            icon = Icons.Rounded.Kitchen,
            screen = NavigationScreen.LoginScreen.route,
            hasNews = false
        ), NavigationButton(
            title = "Tips",
            icon = Icons.Rounded.LightbulbCircle,
            screen = NavigationScreen.PlanScreen.route,
            hasNews = false
        ), NavigationButton(
            title = "News",
            icon = Icons.Rounded.Message,
            screen = NavigationScreen.LoginScreen.route,
            hasNews = true,
            badgeCount = 2
        ), NavigationButton(
            title = "Profile",
            icon = Icons.Rounded.Person,
            screen = NavigationScreen.PlanScreen.route,
            hasNews = false
        )
    )
}