package com.example.mealmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mealmanager.ui.MealViewModel
import com.example.mealmanager.ui.screens.*
import com.example.mealmanager.ui.theme.MealManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealManagerTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: MealViewModel = hiltViewModel()

    val navItems = listOf("dashboard", "calendar", "deposits", "settings")
    val currentRoute = remember { mutableStateOf("dashboard") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") },
                    selected = currentRoute.value == "dashboard",
                    onClick = {
                        currentRoute.value = "dashboard"
                        navController.navigate("dashboard")
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                    label = { Text("Calendar") },
                    selected = currentRoute.value == "calendar",
                    onClick = {
                        currentRoute.value = "calendar"
                        navController.navigate("calendar")
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    label = { Text("Deposits") },
                    selected = currentRoute.value == "deposits",
                    onClick = {
                        currentRoute.value = "deposits"
                        navController.navigate("deposits")
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    label = { Text("Settings") },
                    selected = currentRoute.value == "settings",
                    onClick = {
                        currentRoute.value = "settings"
                        navController.navigate("settings")
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("dashboard") { DashboardScreen(viewModel) }
            composable("calendar") { CalendarScreen(viewModel) }
            composable("deposits") { DepositScreen(viewModel) }
            composable("settings") { SettingsScreen(viewModel) }
        }
    }
}
