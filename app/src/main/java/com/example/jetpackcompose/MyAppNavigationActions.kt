package com.example.jetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class MyAppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: MyAppTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

data class MyAppTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.HOME,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.home
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.ACCOUNT,
        selectedIcon = Icons.Default.AccountCircle,
        iconTextId = R.string.account
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.SETTINGS,
        selectedIcon = Icons.Default.Settings,
        iconTextId = R.string.settings
    ),
)

object MyAppRoute {
    const val HOME = "home"
    const val ACCOUNT = "account"
    const val SETTINGS = "settings"
}