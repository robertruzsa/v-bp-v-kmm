package com.robertruzsa.vbpvkmm.android.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.robertruzsa.vbpvkmm.android.features.offers.OffersScreen
import com.robertruzsa.vbpvkmm.android.ui.components.BottomNavItem
import com.robertruzsa.vbpvkmm.android.ui.components.BottomNavigationBar
import com.robertruzsa.vbpvkmm.common.domain.Screen

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val mainScreens = listOf(Screen.Filter.route, Screen.CreateOffer.route)
    Scaffold(
        bottomBar = {
            if (navBackStackEntry?.destination?.route in mainScreens) {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = Screen.Filter.title,
                            route = Screen.Filter.route,
                            icon = Icons.Default.Search
                        ),
                        BottomNavItem(
                            name = Screen.CreateOffer.title,
                            route = Screen.CreateOffer.route,
                            icon = Icons.Default.Add
                        )
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = Screen.Filter.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = Screen.Filter.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween()
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween()
                    )
                }
            ) {
                // FilterScreen(navController)
                OffersScreen(navController)
            }
            composable(
                route = Screen.CreateOffer.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween()
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween()
                    )
                }
            ) {
                // CreateOfferScreen(navController)
            }
            composable(
                route = Screen.SearchLocation.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Up,
                        animationSpec = tween()
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Down,
                        animationSpec = tween()
                    )
                }
            ) {
                // SearchLocationScreen(navController)
            }
            composable(
                route = Screen.Offers.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween()
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween()
                    )
                }
            ) {
                OffersScreen(navController)
            }
            composable(
                route = Screen.Calendar.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Up,
                        animationSpec = tween()
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Down,
                        animationSpec = tween()
                    )
                }
            ) {
                // CalendarScreen(navController)
            }
        }
    }
}
