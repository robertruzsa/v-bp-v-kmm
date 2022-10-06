package com.robertruzsa.vbpvkmm.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.robertruzsa.vbpvkmm.android.ui.theme.AppTheme
import com.robertruzsa.vbpvkmm.common.domain.Screen
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()
            AppTheme {
                AnimatedNavHost(
                    navController = navController,
                    startDestination = Screen.Posts.route
                ) {
                    /*composable(
                        route = Screen.Login.route,
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentScope.SlideDirection.Left,
                                animationSpec = tween()
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentScope.SlideDirection.Left,
                                animationSpec = tween()
                            )
                        }
                    ) { LoginScreen(navController) }*/
                    composable(
                        route = Screen.Posts.route,
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentScope.SlideDirection.Left,
                                animationSpec = tween()
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentScope.SlideDirection.Left,
                                animationSpec = tween()
                            )
                        }
                    ) { MainScreen() }
                }
            }
        }
    }
}
