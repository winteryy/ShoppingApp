package com.winterry.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.winterry.presentation.R
import com.winterry.presentation.ui.theme.ShoppingAppTheme

sealed class MainNavigationItem(var route: String, var name: String) {
    object Main: MainNavigationItem("Main", "Main")
    object Category: MainNavigationItem("Category", "Category")
    object MyPage: MainNavigationItem("MyPage", "MyPage")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingAppTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MainBottomNavigationBar(navController)
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            MainNavigationScreen(navController = navController)
        }
    }
}

@Composable
fun MainBottomNavigationBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        MainNavigationItem.Main,
        MainNavigationItem.Category,
        MainNavigationItem.MyPage,
    )

    NavigationBar(
        containerColor = Color(0xffff0000),
        contentColor = Color(0xff00ff00)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(painterResource(id = R.drawable.ic_launcher_foreground), item.route) })
        }
    }
}

@Composable
fun MainNavigationScreen(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainNavigationItem.Main.route,
        builder = {
            composable(MainNavigationItem.Main.route) {
                Text("Hello Main")
            }
            composable(MainNavigationItem.Category.route) {
                Text("Hello Category")
            }
            composable(MainNavigationItem.MyPage.route) {
                Text("Hello MyPage")
            }
        }
    )
}

