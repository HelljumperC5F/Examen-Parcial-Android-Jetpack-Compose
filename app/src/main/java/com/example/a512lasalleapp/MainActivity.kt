package com.example.a512lasalleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a512lasalleapp.ui.screens.CalendarScreen
import com.example.a512lasalleapp.ui.screens.ClassDetails
import com.example.a512lasalleapp.ui.screens.EmptyScreen
import com.example.a512lasalleapp.ui.screens.GradesScreen
import com.example.a512lasalleapp.ui.screens.HomeScreen
import com.example.a512lasalleapp.ui.screens.NewsDetailScreen
import com.example.a512lasalleapp.ui.screens.PagosScreen
import com.example.a512lasalleapp.ui.screens.SettingsScreen
import com.example.a512lasalleapp.ui.theme._512LaSalleAppTheme
import com.example.a512lasalleapp.ui.utils.Screens
import com.example.a512lasalleapp.ui.utils.bottomNavBarItems
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComposable()
        }
    }
}

@Preview
@Composable
fun MainComposable() {
    // Probably the responsible for navigation
    val navController = rememberNavController()

    // `rememberSaveable` is a function that ensures that the value `selectedItemIndex`
    // is saved and *remembered* with each "activity or process recreation".

    // The `by` operator is responsible for delegating the `set` and `get` of the variable
    // so in this case, when you do `selectedItemIndex = someValue` it's not the normal
    // Kotlin logic that is gonna handle the setting, its the logic implemented inside
    // `rememberSaveable`.
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }


    val bottomNavRoutes = listOf(
        Screens.Home.route,
        Screens.Grades.route,
        Screens.Settings.route,
        Screens.Calendar.route
    )
    _512LaSalleAppTheme {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                if(currentRoute in bottomNavRoutes) {
                    AnimatedNavigationBar(
                        selectedIndex = selectedItemIndex,
                        barColor = MaterialTheme.colorScheme.primary,
                        ballColor = MaterialTheme.colorScheme.primary,
                        cornerRadius = shapeCornerRadius(topLeft = 34.dp, topRight = 34.dp, bottomLeft = 0.dp, bottomRight = 0.dp),
                        modifier = Modifier.height(90.dp),
                    ) {
                        bottomNavBarItems.forEachIndexed { index, bottomNavigationItem ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        selectedItemIndex = index
                                        navController.navigate(bottomNavigationItem.route)
                                    }
                            ) {
                                Icon(
                                    imageVector = bottomNavigationItem.icon,
                                    contentDescription = bottomNavigationItem.title,
                                    tint = if (selectedItemIndex == index) Color.White else Color.White.copy(
                                        alpha = 0.5f
                                    ),
                                    modifier = Modifier.size(26.dp)
                                )
                                Text(
                                    text = bottomNavigationItem.title,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = if (selectedItemIndex == index) Color.White else Color.White.copy(
                                        alpha = 0.5f
                                    ),
                                )
                            }
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = Screens.Home.route) {
                composable(route = Screens.Home.route) {
                    HomeScreen(innerPadding = innerPadding, navController = navController)
                }
                composable(route = Screens.Calendar.route){
                    CalendarScreen(innerPadding = innerPadding)
                }
                composable(route = Screens.Grades.route){
                    GradesScreen(innerPadding = innerPadding, navController = navController)
                }
                composable(route = Screens.Settings.route) {
                    SettingsScreen(innerPadding = innerPadding, navController = navController)
                }
                composable(
                    route = Screens.NewsDetail.route+"/{id}",
                    arguments = listOf(
                        navArgument("id"){
                            type = NavType.IntType
                            nullable = false
                        }
                    )
                ) {
                    val id = it.arguments?.getInt("id",0) ?: 0
                    NewsDetailScreen(newsId=id,innerPadding = innerPadding)
                }
                composable(
                    route = Screens.ClassDetails.route+"/{id}",
                    arguments = listOf(
                        navArgument("id") {
                            type = NavType.IntType
                            nullable = false
                        }
                    )
                ) {
                    val id = it.arguments?.getInt("id", 0) ?: 0
                    ClassDetails(classId = id, innerPadding = innerPadding)
                }
                composable(route = Screens.Empty.route) {
                    EmptyScreen()
                }
                composable(route = Screens.Pagos.route) {
                    PagosScreen()
                }
            }
        }
    }
}